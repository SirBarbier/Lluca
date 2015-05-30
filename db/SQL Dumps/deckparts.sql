-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.21 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             9.1.0.4913
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
-- Dumping data for table lluca_master.deckparts: ~0 rows (approximately)
/*!40000 ALTER TABLE `deckparts` DISABLE KEYS */;
INSERT INTO `deckparts` (`deckpart_id`, `deckpart_name`, `deckpart_box_id`, `deckpart_box`, `deckpart_cycle`, `deckpart_parent`) VALUES
	(1, 'Spiders of Mirkwood', 1, 'Core Set', 'Shadows of Mirkwood', 0),
	(2, 'Passage Through Mirkwood', 1, 'Core Set', 'Shadows of Mirkwood', 1),
	(3, 'Journey Down the Anduin', 1, 'Core Set', 'Shadows of Mirkwood', 1),
	(4, 'Wilderlands', 1, 'Core Set', 'Shadows of Mirkwood', 0),
	(5, 'Escape from Dol Guldur', 1, 'Core Set', 'Shadows of Mirkwood', 1),
	(6, 'Dol Guldur Orcs', 1, 'Core Set', 'Shadows of Mirkwood', 0),
	(7, 'Saurons Reach', 1, 'Core Set', 'Shadows of Mirkwood', 0),
	(8, 'The Hunt for Gollum', 2, 'The Hunt for Gollum', 'Shadows of Mirkwood', 1),
	(9, 'Conflict at the Carrock', 3, 'Conflict at the Carrock', 'Shadows of Mirkwood', 1),
	(10, 'A Journey to Rhosgobel', 4, 'A Journey to Rhosgobel', 'Shadows of Mirkwood', 1),
	(11, 'The Hills of Emyn Muil', 5, 'The Hills of Emyn Muil', 'Shadows of Mirkwood', 1),
	(12, 'The Dead Marshes', 6, 'The Dead Marshes', 'Shadows of Mirkwood', 1),
	(13, 'Return to Mirkwood', 7, 'Return to Mirkwood', 'Shadows of Mirkwood', 1),
	(14, 'Twists and Turns', 8, 'Khazad-dum', 'Dwarrowdelf', 0),
	(15, 'Plundering Goblins', 8, 'Khazad-dum', 'Dwarrowdelf', 0),
	(16, 'Misty Mountains', 8, 'Khazad-dum', 'Dwarrowdelf', 0),
	(17, 'Into the Pit', 8, 'Khazad-dum', 'Dwarrowdelf', 1),
	(18, 'Hazards of the Pit', 8, 'Khazad-dum', 'Dwarrowdelf', 0),
	(19, 'Goblins of the Deep', 8, 'Khazad-dum', 'Dwarrowdelf', 0),
	(20, 'Flight from Moria', 8, 'Khazad-dum', 'Dwarrowdelf', 1),
	(21, 'Deeps of Moria', 8, 'Khazad-dum', 'Dwarrowdelf', 0),
	(22, 'The Redhorn Gate', 9, 'The Redhorn Gate', 'Dwarrowdelf', 1),
	(23, 'Road to Rivendell', 10, 'Road to Rivendell', 'Dwarrowdelf', 1),
	(24, 'The Watcher in the Water', 11, 'The Watcher in the Water', 'Dwarrowdelf', 1),
	(25, 'The Long Dark', 12, 'The Long Dark', 'Dwarrowdelf', 1),
	(26, 'Foundations of Stone', 13, 'Foundations of Stone', 'Dwarrowdelf', 1),
	(27, 'Shadow and Flame', 14, 'Shadow and Flame', 'Dwarrowdelf', 1),
	(28, 'The Siege of Cair Andros', 15, 'Heirs of Numenor', 'Against the Shadow', 1),
	(29, 'Streets of Gondor', 15, 'Heirs of Numenor', 'Against the Shadow', 0),
	(30, 'Southrons', 15, 'Heirs of Numenor', 'Against the Shadow', 0),
	(31, 'Ravaging Orcs', 15, 'Heirs of Numenor', 'Against the Shadow', 0),
	(32, 'Peril in Pelargir', 15, 'Heirs of Numenor', 'Against the Shadow', 1),
	(33, 'Mordor Elite', 15, 'Heirs of Numenor', 'Against the Shadow', 0),
	(34, 'Into Ithilien', 15, 'Heirs of Numenor', 'Against the Shadow', 1),
	(35, 'Creatures of the Forest', 15, 'Heirs of Numenor', 'Against the Shadow', 0),
	(36, 'Brooding Forest', 15, 'Heirs of Numenor', 'Against the Shadow', 0),
	(37, 'Brigands', 15, 'Heirs of Numenor', 'Against the Shadow', 0),
	(38, 'The Stewards Fear', 16, 'The Stewards Fear', 'Against the Shadow', 1),
	(39, 'The Druadan Forest', 17, 'The Druadan Forest', 'Against the Shadow', 1),
	(40, 'Encounter at Amon Din', 18, 'Encounter at Amon Din', 'Dwarrowdelf', 1),
	(41, 'Assault on Osgiliath', 19, 'Assault on Osgiliath', 'Against the Shadow', 1),
	(42, 'The Blood of Gondor', 20, 'The Blood of Gondor', 'Against the Shadow', 1),
	(43, 'The Morgul Vale', 21, 'The Morgul Vale', 'Against the Shadow', 1),
	(44, 'Weary Travelers', 22, 'The Voice of Isengard', 'The Ring-maker', 0),
	(45, 'To Catch an Orc', 22, 'The Voice of Isengard', 'The Ring-maker', 1),
	(46, 'The Fords of Isen', 22, 'The Voice of Isengard', 'The Ring-maker', 1),
	(47, 'The Dunland Warriors', 22, 'The Voice of Isengard', 'The Ring-maker', 0),
	(48, 'The Dunland Raiders', 22, 'The Voice of Isengard', 'The Ring-maker', 0),
	(49, 'Misty Mountain Orcs', 22, 'The Voice of Isengard', 'The Ring-maker', 0),
	(50, 'Into Fangorn', 22, 'The Voice of Isengard', 'The Ring-maker', 1),
	(51, 'Broken Lands', 22, 'The Voice of Isengard', 'The Ring-maker', 0),
	(52, 'Ancient Forest', 22, 'The Voice of Isengard', 'The Ring-maker', 0),
	(53, 'Wilderland', 23, 'On the Doorstep', 'Hobbit', 0),
	(54, 'The Lonely Mountain', 23, 'On the Doorstep', 'Hobbit', 1),
	(55, 'The Battle of Five Armies', 23, 'On the Doorstep', 'Hobbit', 1),
	(56, 'Flies and Spiders', 23, 'On the Doorstep', 'Hobbit', 1),
	(57, 'Western Lands', 24, 'Over Hill and Under Hill', 'Hobbit', 0),
	(58, 'We Must Away Ere Break of Day', 24, 'Over Hill and Under Hill', 'Hobbit', 1),
	(59, 'The Great Goblin', 24, 'Over Hill and Under Hill', 'Hobbit', 0),
	(60, 'Over the Misty Mountains Grim', 24, 'Over Hill and Under Hill', 'Hobbit', 1),
	(61, 'Misty Mountain Goblins', 24, 'Over Hill and Under Hill', 'Hobbit', 0),
	(62, 'Dungeons Deep and Caverns Dim', 24, 'Over Hill and Under Hill', 'Hobbit', 1),
	(63, 'The Battle of Lake-town', 25, 'The Battle of Lake-town', 'POD', 1),
	(64, 'The Massing at Osgiliath', 26, 'The Massing at Osgiliath', 'POD', 1),
	(65, 'The Stone of Erech', 27, 'The Stone of Erech', 'POD', 1),
	(66, 'The Ring', 28, 'The Black Riders', 'The Black Riders', 0),
	(67, 'The Nazgul', 28, 'The Black Riders', 'The Black Riders', 0),
	(68, 'The Black Riders', 28, 'The Black Riders', 'The Black Riders', 0),
	(69, 'Hunted', 28, 'The Black Riders', 'The Black Riders', 0),
	(70, 'Flight to the Ford', 28, 'The Black Riders', 'The Black Riders', 1),
	(71, 'A Shadow of the Past', 28, 'The Black Riders', 'The Black Riders', 1),
	(72, 'A Knife in the Dark', 28, 'The Black Riders', 'The Black Riders', 1);
/*!40000 ALTER TABLE `deckparts` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
