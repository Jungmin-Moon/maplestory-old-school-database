CREATE TABLE `artale_mobs` (
  `mob_ID` int NOT NULL AUTO_INCREMENT,
  `mob_Name` text,
  `mob_Level` double DEFAULT NULL,
  `mob_HP` bigint DEFAULT NULL,
  `mob_MP` bigint DEFAULT NULL,
  `mob_EXP` bigint DEFAULT NULL,
  `mob_Min_Meso` int DEFAULT NULL,
  `mob_Max_Meso` int DEFAULT NULL,
  `mob_Needed_Accuracy` bigint DEFAULT NULL,
  `mob_Location` text,
  `mob_Location_Two` text,
  PRIMARY KEY (`mob_ID`)
)