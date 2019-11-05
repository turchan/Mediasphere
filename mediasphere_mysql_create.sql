CREATE TABLE `users` (
	`id_user` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL,
	`surname` varchar(50) NOT NULL,
	`email` varchar(50) NOT NULL,
	`workplace` varchar(50) NOT NULL,
	`position` varchar(50) NOT NULL,
	`location` varchar(50) NOT NULL,
	`country` varchar(50) NOT NULL,
	`city` varchar(50) NOT NULL,
	`phone` varchar(50) NOT NULL,
	`points` INT NOT NULL,
	`password` varchar(25) NOT NULL,
	`vk` varchar(100),
	`fb` varchar(100),
	`twitter` varchar(100),
	`website` varchar(100),
	`verified` INT NOT NULL,
	`registered` TIMESTAMP NOT NULL,
	`id_role` INT NOT NULL,
	PRIMARY KEY (`id_user`)
);

CREATE TABLE `roles` (
	`id_role` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(20) NOT NULL,
	PRIMARY KEY (`id_role`)
);

CREATE TABLE `contacts` (
	`id_contact` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL,
	`surname` varchar(50) NOT NULL,
	`information` TEXT NOT NULL,
	`email` varchar(50) NOT NULL,
	`phone` varchar(50) NOT NULL,
	`workplace` varchar(50) NOT NULL,
	`position` varchar(50) NOT NULL,
	`location` varchar(50) NOT NULL,
	`country` varchar(50) NOT NULL,
	`city` varchar(50) NOT NULL,
	`price` INT NOT NULL,
	`verified` INT NOT NULL,
	`registered` TIMESTAMP NOT NULL,
	`views` INT NOT NULL,
	`id_author` INT NOT NULL,
	PRIMARY KEY (`id_contact`)
);

CREATE TABLE `contacts_spheres` (
	`id_contact_sphere` INT NOT NULL AUTO_INCREMENT,
	`id_contact` INT NOT NULL,
	`id_sphere` INT NOT NULL,
	PRIMARY KEY (`id_contact_sphere`)
);

CREATE TABLE `spheres` (
	`id_sphere` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(200) NOT NULL,
	PRIMARY KEY (`id_sphere`)
);

CREATE TABLE `purchases` (
	`id_purchase` INT NOT NULL AUTO_INCREMENT,
	`id_buyer` INT NOT NULL,
	`id_contact` INT NOT NULL,
	PRIMARY KEY (`id_purchase`)
);

CREATE TABLE `materials` (
	`id_material` INT NOT NULL AUTO_INCREMENT,
	`title` varchar(50) NOT NULL,
	`description` TEXT NOT NULL,
	`location` varchar(100) NOT NULL,
	`deadline` DATE NOT NULL,
	`id_author` INT NOT NULL,
	`verified` INT NOT NULL,
	`registered` TIMESTAMP NOT NULL,
	`views` INT NOT NULL,
	PRIMARY KEY (`id_material`)
);

CREATE TABLE `materials_spheres` (
	`id_material_sphere` INT NOT NULL AUTO_INCREMENT,
	`id_material` INT NOT NULL,
	`id_sphere` INT NOT NULL,
	PRIMARY KEY (`id_material_sphere`)
);

CREATE TABLE `reports` (
	`id_report` INT NOT NULL AUTO_INCREMENT,
	`title` varchar(50) NOT NULL,
	`content` TEXT NOT NULL,
	`id_sender` INT NOT NULL,
	`id_contact` INT NOT NULL,
	`sent` TIMESTAMP NOT NULL,
	PRIMARY KEY (`id_report`)
);

CREATE TABLE `notifications` (
	`id_notification` INT NOT NULL AUTO_INCREMENT,
	`title` varchar(50) NOT NULL,
	`content` TEXT NOT NULL,
	`id_type` INT NOT NULL,
	`id_user` INT NOT NULL,
	`occurred` TIMESTAMP NOT NULL,
	PRIMARY KEY (`id_notification`)
);

CREATE TABLE `notifications_types` (
	`id_notification_type` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(25) NOT NULL,
	PRIMARY KEY (`id_notification_type`)
);

ALTER TABLE `users` ADD CONSTRAINT `users_fk0` FOREIGN KEY (`id_role`) REFERENCES `roles`(`id_role`);

ALTER TABLE `contacts` ADD CONSTRAINT `contacts_fk0` FOREIGN KEY (`id_author`) REFERENCES `users`(`id_user`);

ALTER TABLE `contacts_spheres` ADD CONSTRAINT `contacts_spheres_fk0` FOREIGN KEY (`id_contact`) REFERENCES `contacts`(`id_contact`);

ALTER TABLE `contacts_spheres` ADD CONSTRAINT `contacts_spheres_fk1` FOREIGN KEY (`id_sphere`) REFERENCES `spheres`(`id_sphere`);

ALTER TABLE `purchases` ADD CONSTRAINT `purchases_fk0` FOREIGN KEY (`id_buyer`) REFERENCES `users`(`id_user`);

ALTER TABLE `purchases` ADD CONSTRAINT `purchases_fk1` FOREIGN KEY (`id_contact`) REFERENCES `contacts`(`id_contact`);

ALTER TABLE `materials` ADD CONSTRAINT `materials_fk0` FOREIGN KEY (`id_author`) REFERENCES `users`(`id_user`);

ALTER TABLE `materials_spheres` ADD CONSTRAINT `materials_spheres_fk0` FOREIGN KEY (`id_material`) REFERENCES `materials`(`id_material`);

ALTER TABLE `materials_spheres` ADD CONSTRAINT `materials_spheres_fk1` FOREIGN KEY (`id_sphere`) REFERENCES `spheres`(`id_sphere`);

ALTER TABLE `reports` ADD CONSTRAINT `reports_fk0` FOREIGN KEY (`id_sender`) REFERENCES `users`(`id_user`);

ALTER TABLE `reports` ADD CONSTRAINT `reports_fk1` FOREIGN KEY (`id_contact`) REFERENCES `contacts`(`id_contact`);

ALTER TABLE `notifications` ADD CONSTRAINT `notifications_fk0` FOREIGN KEY (`id_type`) REFERENCES `notifications_types`(`id_notification_type`);

ALTER TABLE `notifications` ADD CONSTRAINT `notifications_fk1` FOREIGN KEY (`id_user`) REFERENCES `users`(`id_user`);

