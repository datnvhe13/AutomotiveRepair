
-- Drop the database if it already exists
DROP DATABASE IF EXISTS Assignment_Final;
-- Create database
CREATE DATABASE IF NOT EXISTS Assignment_Final;
USE Assignment_Final;

-- Create table Car
DROP TABLE IF EXISTS 	Car;
CREATE TABLE IF NOT EXISTS Car (
	license_plate 			NVARCHAR(50) NOT NULL,
	repair_date 			DATETIME DEFAULT NOW(),
    customer_name			NVARCHAR(50) NOT NULL,
    catalogs				NVARCHAR(50) NOT NULL,
	car_maker				NVARCHAR(50) NOT NULL,
    PRIMARY KEY (license_plate, repair_date)
);
-- =============================================
-- INSERT DATA 
-- =============================================
-- Add data Department
INSERT INTO Car(	license_plate, 		repair_date, 	customer_name, 		catalogs, car_maker) 
VALUES
						(N'30A-33333'	, 		'2023-09-01',		'customer_name_1', 			'catalogs_1', 'Volvol'),
                        (N'30A-33379'	, 		'2023-09-03',		'customer_name_2', 			'catalogs_2', 'Audi'),
						(N'30A-33322'	, 		'2023-09-05',		'customer_name_3', 			'catalogs_3', 'Vinfast'),
                        (N'29A-66666'	, 		'2023-09-08',		'customer_name_4', 			'catalogs_4', 'Vinfast'),
                        (N'29A-66699'	, 		'2023-09-12',		'customer_name_5', 			'catalogs_5', 'Kia');


-- Create table Car
DROP TABLE IF EXISTS 	Accessory;
CREATE TABLE IF NOT EXISTS Accessory (
	id 			INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    license_plate 			NVARCHAR(50) NOT NULL,
	repair_date 			DATETIME DEFAULT NOW(),
    `name`					NVARCHAR(50) NOT NULL,
    price					FLOAT NOT NULL,
    status_damaged			NVARCHAR(50) NOT NULL,
    repair_status			NVARCHAR(50) NOT NULL,
    CONSTRAINT fk_accessory_01 FOREIGN KEY(license_plate, repair_date) REFERENCES Car(license_plate, repair_date) 
    -- ON DELETE CASCADE
) ENGINE = InnoDB;

DELETE FROM Accessory WHERE id = 6;

-- =============================================
-- INSERT DATA 
-- =============================================
-- Add data Department
INSERT INTO Accessory(	license_plate, 		repair_date, 	`name`, price,		status_damaged, 	repair_status) 
VALUES
						(N'30A-33333'	, 		'2023-09-01',		'Lọc gió', 			100000	,	'Bị bụi bẩn',	'Làm sạch'	),
                        (N'30A-33379'	, 		'2023-09-03',		'Lọc dầu', 			500000	,	'Bị tắc nghẽn',	'Thay mới'	),
						(N'30A-33322'	, 		'2023-09-05',		'Dây Coloa', 			100000	,	'Bị dãn',	'Thay mới'	),
                        (N'29A-66666'	, 		'2023-09-08',		'Hai lốp trước', 			5000000	,	'Bị mòn',	'Thay mới'	),
                        (N'29A-66699'	, 		'2023-09-12',		'Dầu máy', 			800000	,	'Hết',	'Thay mới'	);











