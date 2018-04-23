DROP TABLE IF EXISTS `T_POST`;

CREATE TABLE `T_POST`(
  `id`                 	BIGINT			NOT NULL AUTO_INCREMENT,
  `title`              	VARCHAR(255)	NOT NULL,
  `content`				TEXT,
  `creationDate`		DATETIME,
  PRIMARY KEY (`id`)
);