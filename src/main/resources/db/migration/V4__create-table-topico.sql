CREATE TABLE `topico` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(60) NOT NULL,
  `mensaje` VARCHAR(250) NOT NULL,
  `fecha_creacion` DATETIME NOT NULL,
  `status` TINYINT NOT NULL,
  `autor_id` BIGINT NULL,
  `curso_id` BIGINT NULL,
  `respuestas_id` BIGINT NULL,
  PRIMARY KEY (`id`));