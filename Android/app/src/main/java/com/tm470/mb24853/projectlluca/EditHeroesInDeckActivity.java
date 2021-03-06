package com.tm470.mb24853.projectlluca;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class EditHeroesInDeckActivity extends ActionBarActivity {

    LLuca_Local_DB_Helper db_helper = new LLuca_Local_DB_Helper(this, null, null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_heroes_in_deck);
        getWindow().getDecorView().setBackgroundColor(Color.rgb(169, 186, 182));

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);

        Bundle bundle = getIntent().getExtras();
        final String deckname = bundle.getString("deckname");
        final String deckname2 = bundle.getString("deckname") + " current heroes";

        TextView deckName = (TextView) findViewById(R.id.editDeckTextName);
        deckName.setText(deckname2);

        //loads the available heroes into list view
        Cursor cursor = db_helper.getHeroCardsInDeck(deckname, "Hero");
        final ListView cards = (ListView) findViewById(R.id.cardsInDecklistView);
        final tableadapter_customdeckcards_helper adapter = new tableadapter_customdeckcards_helper(this, cursor, false);
        cards.setAdapter(adapter);

        cards.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                TextView currentCard = (TextView) view.findViewById(R.id.custom_deck_template_card_name);
                String text = currentCard.getText().toString();
                displayCardDialog(text);
                //makeMeToast(text,1);

            }
        });

        cards.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                TextView currentCard = (TextView) view.findViewById(R.id.custom_deck_template_card_name);
                String text = currentCard.getText().toString();
                db_helper.deleteCardFromDeck(deckname, text);
                makeMeToast("Card removed", 1, "BOTTOM", 0, 0, 15);
                adapter.notifyDataSetInvalidated();
                Cursor cursor2 = db_helper.getHeroCardsInDeck(deckname, "Hero");
                final tableadapter_customdeckcards_helper adapter2 = new tableadapter_customdeckcards_helper(EditHeroesInDeckActivity.this, cursor2, false);
                cards.setAdapter(adapter2);
                return true;
            }
        });
        setFonts();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_heroes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        switch (item.getItemId()) {

            case R.id.action_back:
                Bundle bundle = getIntent().getExtras();
                String deckname = bundle.getString("deckname");
                Intent intent = new Intent(this,EditDeckActivity.class);
                intent.putExtra("deckname", deckname);
                startActivity(intent);
                //makeMeToast("back",1);

                return true;
            case R.id.action_home:
                Intent goHome = new Intent(this,MainMenuActivity.class);
                startActivity(goHome);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void add_cards_to_deck(View view)
    {
        Bundle bundle = getIntent().getExtras();
        final String deckname = bundle.getString("deckname");

        if (db_helper.howManyHeroes(deckname) < 3) {
            //loads the card browser screen and passes through the deckname
            Intent intent = new Intent(this, AddHeroCardsToDeckCardBrowserActivity.class);
            intent.putExtra("deckname", deckname);
            intent.putExtra("threat", "Any");
            intent.putExtra("sphere", "All");

            startActivity(intent);
        }
        else
        {
            makeMeToast("You have the maximum of 3 allowed heroes in this deck already.",1, "BOTTOM", 0,0,15);
        }

    }

    //helper method to make toast, takes a String input for the message and an integer
    //input for the duration (0 is short, 1 is long, default long)
    public void makeMeToast(String message, int length, String position, int xOffset, int yOffset, int fontSize)
    {

        int howBrownDoYouWantIt;

        switch (length) {

            case 0: howBrownDoYouWantIt = Toast.LENGTH_SHORT;
                break;
            case 1: howBrownDoYouWantIt = Toast.LENGTH_LONG;
                break;
            default: howBrownDoYouWantIt = Toast.LENGTH_LONG;
                break;
        }

        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, message, howBrownDoYouWantIt);
        if (position.equals("TOP")) {
            toast.setGravity(Gravity.TOP, xOffset, yOffset);
        }
        else if (position.equals("BOTTOM"))
        {
            toast.setGravity(Gravity.BOTTOM, xOffset, yOffset);
        }
        if (fontSize == 0)
        {
            fontSize = 15;
        }

        //makes the toast text size bigger
        LinearLayout layout = (LinearLayout) toast.getView();
        TextView tv = (TextView) layout.getChildAt(0);
        tv.setTextSize(fontSize);
        Typeface font2 = Typeface.createFromAsset(getAssets(), "Fonts/ringbearer.ttf");
        tv.setTypeface(font2);
        toast.show();
    }

    public void displayCardDialog(String text)
    {
        final Dialog cardDetailsDialogue = new Dialog(this);
        cardDetailsDialogue.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Typeface font = Typeface.createFromAsset(getAssets(), "Fonts/aniron.ttf");
        cardDetailsDialogue.setContentView(R.layout.custom_dialogue_cardetails);

        final Button okButton = (Button) cardDetailsDialogue.findViewById(R.id.okButtonSearch);
        final TextView cardDataView = (TextView) cardDetailsDialogue.findViewById(R.id.cardInfo);
        cardDataView.setTypeface(font);
        okButton.setTypeface(font);
        cardDataView.setTextSize(9);
        okButton.setTextSize(9);

        heroesClass card = db_helper.findAHeroCard(text);
        String keywords;
        String traits;

        if (!card.getHerocard_keyword1().equals("")) {
            keywords = card.getHerocard_keyword1();
            if (!card.getHerocard_keyword2().equals(""))
            {
                keywords = keywords + ", " + card.getHerocard_keyword2();
                if (!card.getHerocard_keyword3().equals(""))
                {
                    keywords = keywords + ", " + card.getHerocard_keyword3();
                    if (!card.getHerocard_keyword4().equals(""))
                    {
                        keywords = keywords + card.getHerocard_keyword4();
                    }
                }
            }
        }
        else { keywords = "None"; }
        if (!card.getHerocard_trait1().equals("")){

            traits = card.getHerocard_trait1();
            if (!card.getHerocard_trait2().equals(""))
            {
                traits = traits + ", " + card.getHerocard_trait2();
                if (!card.getHerocard_trait3().equals(""))
                {
                    traits = traits + ", " + card.getHerocard_trait3();
                    if (!card.getHerocard_trait4().equals(""))
                    {
                        traits = traits + ", " + card.getHerocard_trait4();
                    }
                }
            }
        }
        else {traits = "None";}

        final String textForDisplay = "Name: " + card.getHerocard_name() + "\nNumber: " + card.getHerocard_no() + "\nThreat: " + card.getHerocard_threat() + "\nQuest: " + card.getHerocard_quest() + "\nAttack: " + card.getHerocard_attack() + "\nDefence: " + card.getHerocard_hp() + "\nHP: " + card.getHerocard_hp() + "\nKeywords: " + keywords + "\nTraits: " + traits + "\nSpecial Text: " + card.getHerocard_specialrules();
        cardDataView.setText(textForDisplay);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cardDetailsDialogue.dismiss();
            }
        });

        String imgPath = db_helper.getImagePath(card.getHerocard_name(),"hero");
        final WebView frame = (WebView) cardDetailsDialogue.findViewById(R.id.cardImageView);
        frame.setBackgroundColor(Color.rgb(151, 199, 188));
        frame.loadDataWithBaseURL(null, imgPath, "text/html", "utf-8", null);

        cardDetailsDialogue.show();
        Window window = cardDetailsDialogue.getWindow();
        window.setLayout(550, 900);
    }

    public void setFonts()
    {
        Typeface font = Typeface.createFromAsset(getAssets(), "Fonts/aniron.ttf");
        Typeface font2 = Typeface.createFromAsset(getAssets(), "Fonts/ringbearer.ttf");

        TextView a = (TextView) findViewById(R.id.editDeckTextName);
        TextView b = (TextView) findViewById(R.id.editHeroes1);
        Button c = (Button) findViewById(R.id.edit_deck_addcards);

        a.setTypeface(font2);
        b.setTypeface(font2);
        c.setTypeface(font2);
    }
}
