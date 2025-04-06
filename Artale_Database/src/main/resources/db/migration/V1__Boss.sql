CREATE TABLE `artale_boss` (
  `boss_ID` int NOT NULL,
  `boss_Name` text,
  `boss_Level` int DEFAULT NULL,
  `boss_HP` int DEFAULT NULL,
  `boss_Min_Respawn` int DEFAULT NULL,
  `boss_Max_Respawn` int DEFAULT NULL,
  `boss_Location` text,
  PRIMARY KEY (`boss_ID`)
)