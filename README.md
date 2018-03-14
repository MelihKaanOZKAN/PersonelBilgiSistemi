# PersonelBilgiSistemi
İnternet Programcılığı Projesi

Güncelleme : 08.03.2018 - 10:18

Tablolar güncellendi. Bu kodları çalıştırarak değişiklikleri uygunlayınız.

ALTER TABLE `userperms`
	ALTER `UserIdNum` DROP DEFAULT;
ALTER TABLE `userperms`
	CHANGE COLUMN `UserIdNum` `UserTypeId` INT(11) NOT NULL AFTER `PermissionId`;
	
ALTER TABLE UserPerms ADD CONSTRAINT UserPerms_fk0 FOREIGN KEY (PermissionId) REFERENCES Perms(PermId) ON DELETE CASCADE;

ALTER TABLE UserPerms ADD CONSTRAINT UserPerms_fk1 FOREIGN KEY (UserTypeId) REFERENCES UserTypes(UserTypeId) ON DELETE CASCADE;


Tablolar Güncellendi. İsimleri Değişti. 1 tablo eklendi. 14.03.2018 - 11:52 PM

 RENAME TABLE adresstable TO adress;
 RENAME TABLE citytable TO citys;
 RENAME TABLE commtable TO communicationInfo;
 RENAME TABLE deparmenttable TO departments;
 RENAME TABLE emergencytable TO emergencyInfo;
 RENAME TABLE jobtable TO jobs;
 RENAME TABLE permittable TO permits;
 RENAME TABLE districttable TO districts;
 
CREATE TABLE announcements (
	RecordId INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
	UserGroupId INT(11) UNSIGNED NOT NULL,
	Text TEXT NOT NULL,
	Active BINARY(1) NOT NULL,
	PRIMARY KEY (RecordId)
)
ENGINE=InnoDB
;
