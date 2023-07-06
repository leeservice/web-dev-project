-- Create and Use Statements
create database webDevProjectDb_LeeS;
use webDevProjectDb_LeeS;

-- Drop if tables exist during testing
DROP TABLE IF EXISTS deliveryEmployeeProject;
DROP TABLE IF EXISTS project;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS deliveryEmployee;
DROP TABLE IF EXISTS salesEmployee;
DROP TABLE IF EXISTS `client`;

-- table creation statements
CREATE TABLE employee (
    employeeId SMALLINT UNSIGNED AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    salary DECIMAL(9 , 2 ) NOT NULL,
    bankAccountNo VARCHAR(20) NOT NULL,
    natInsuranceNo CHAR(9) NOT NULL,
    PRIMARY KEY (employeeId)
);

CREATE TABLE salesEmployee (
    employeeId SMALLINT UNSIGNED NOT NULL,
    commissionRate DECIMAL(4 , 3 ) NOT NULL,
    PRIMARY KEY (employeeId),
    FOREIGN KEY (employeeId)
        REFERENCES employee (employeeId)
);

CREATE TABLE deliveryEmployee (
    employeeId SMALLINT UNSIGNED NOT NULL,
    PRIMARY KEY (employeeId),
    FOREIGN KEY (employeeId)
        REFERENCES employee (employeeId)
);

CREATE TABLE `client` (
    clientId SMALLINT UNSIGNED AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    address VARCHAR(255) NOT NULL,
    phoneNo VARCHAR(15) NOT NULL,
    joinDate DATE NOT NULL,
    employeeId SMALLINT UNSIGNED NOT NULL,
    PRIMARY KEY (clientId),
    FOREIGN KEY (employeeId)
        REFERENCES salesEmployee (employeeId)
);

CREATE TABLE project (
    projectId SMALLINT UNSIGNED AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `value` DECIMAL(12 , 2 ) NOT NULL,
    projectStartDate DATE NOT NULL,
    projectCompletedDate DATE,
    techLeadId SMALLINT UNSIGNED NOT NULL,
    clientId SMALLINT UNSIGNED NOT NULL,
    PRIMARY KEY (projectId),
    FOREIGN KEY (techLeadId)
        REFERENCES deliveryEmployee (employeeId),
    FOREIGN KEY (clientId)
        REFERENCES `client` (clientId)
);

CREATE TABLE deliveryEmployeeProject (
    employeeId SMALLINT UNSIGNED AUTO_INCREMENT,
    projectId SMALLINT UNSIGNED NOT NULL,
    employeeInvolvementStartDate DATE NOT NULL,
    employeeInvolvementEndDate DATE NULL,
    PRIMARY KEY (employeeId , projectId, employeeInvolvementStartDate),
    FOREIGN KEY (projectId)
        REFERENCES project (projectId),
    FOREIGN KEY (employeeId)
        REFERENCES deliveryEmployee (employeeId)
);

-- Test Data insertion statements

-- insert employees
INSERT INTO employee (`name`, salary, bankAccountNo, natInsuranceNo) VALUES ('Lee Service', 55000.00,'123456','123456789'); 
INSERT INTO employee (`name`, salary, bankAccountNo, natInsuranceNo) VALUES ('Shaun Gee', 60000.00,'654321','987654321');
INSERT INTO employee (`name`, salary, bankAccountNo, natInsuranceNo) VALUES ('Cormac VersionWan', 62000.00,'654321','987654321'); 
INSERT INTO employee (`name`, salary, bankAccountNo, natInsuranceNo) VALUES ('Michael Allstate', 54000.00,'111222','123454321'); 
INSERT INTO employee (`name`, salary, bankAccountNo, natInsuranceNo) VALUES ('Michael Keenos', 54000.00,'133222','123454897'); 
INSERT INTO employee (`name`, salary, bankAccountNo, natInsuranceNo) VALUES ('Jane Belfast', 32000.00,'333444','333333333'); 
INSERT INTO employee (`name`, salary, bankAccountNo, natInsuranceNo) VALUES ('John Antrim', 22000.00,'444777','444444444'); 
INSERT INTO employee (`name`, salary, bankAccountNo, natInsuranceNo) VALUES ('Dave Botanic', 19000.00,'321678','111111111'); 
INSERT INTO employee (`name`, salary, bankAccountNo, natInsuranceNo) VALUES ('Kelly Kainos', 29000.00,'163333','222222222'); 
INSERT INTO employee (`name`, salary, bankAccountNo, natInsuranceNo) VALUES ('Harry Porter', 37000.00,'321321','321321321'); 

-- salesEmployee Table
INSERT INTO salesEmployee (employeeId,commissionRate) VALUES(1, 1.5);
INSERT INTO salesEmployee (employeeId,commissionRate) VALUES(2, 0.7);
INSERT INTO salesEmployee (employeeId,commissionRate) VALUES(3, 1.1);
INSERT INTO salesEmployee (employeeId,commissionRate) VALUES(4, 1.2);

-- deliveryEmployee Table
INSERT INTO deliveryEmployee (employeeId) VALUES(5);
INSERT INTO deliveryEmployee (employeeId) VALUES(6);
INSERT INTO deliveryEmployee (employeeId) VALUES(7);
INSERT INTO deliveryEmployee (employeeId) VALUES(8);
INSERT INTO deliveryEmployee (employeeId) VALUES(9);
INSERT INTO deliveryEmployee (employeeId) VALUES(10);

-- client Table
INSERT INTO `client` (`name`, address, phoneNo, joinDate, employeeId) VALUES('Netflix', '2 High Street', '07712343434', "2022-05-21", 1);
INSERT INTO `client` (`name`, address, phoneNo, joinDate, employeeId) VALUES('Amazon', '4 High Street', '07711111111', "2021-02-19", 1);
INSERT INTO `client` (`name`, address, phoneNo, joinDate, employeeId) VALUES('Ben & Jerries', '12 Main Street', '07722222222', "2022-05-15", 2);
INSERT INTO `client` (`name`, address, phoneNo, joinDate, employeeId) VALUES('Kainoos sooftwort', '64 Nintendo Street', '07733333333', "2023-01-03", 3);

-- Project Table
INSERT INTO project (`name`, `value`, projectStartDate, projectCompletedDate, techLeadId, clientId) VALUES('Netflix Rebuild', 5000000.00, "2022-06-01", "2023-06-20",  7, 1);
INSERT INTO project (`name`, `value`, projectStartDate, projectCompletedDate, techLeadId, clientId) VALUES('Amazon Project', 2000000.00, "2023-04-25", null,  5, 2);
INSERT INTO project (`name`, `value`, projectStartDate, projectCompletedDate, techLeadId, clientId) VALUES('Stop server melting project', 1000000.00, "2023-02-10", null,  6, 3);
INSERT INTO project (`name`, `value`, projectStartDate, projectCompletedDate, techLeadId, clientId) VALUES('Pyramid Schemes', 500000.00, "2022-04-13", "2023-03-15",  6, 4);


-- DeliveryEmployeeProject Table
INSERT INTO deliveryEmployeeProject (employeeId, projectId, employeeInvolvementStartDate, employeeInvolvementEndDate ) VALUES (7, 1, "2022-06-01","2023-06-20");
INSERT INTO deliveryEmployeeProject (employeeId, projectId, employeeInvolvementStartDate, employeeInvolvementEndDate ) VALUES (6, 3, "2023-05-01","2023-05-08");
INSERT INTO deliveryEmployeeProject (employeeId, projectId, employeeInvolvementStartDate) VALUES (8, 4, "2023-02-10");
INSERT INTO deliveryEmployeeProject (employeeId, projectId, employeeInvolvementStartDate) VALUES (10, 4, "2023-02-09");
INSERT INTO deliveryEmployeeProject (employeeId, projectId, employeeInvolvementStartDate, employeeInvolvementEndDate) VALUES (9, 4, "2023-04-28","2023-07-20");

