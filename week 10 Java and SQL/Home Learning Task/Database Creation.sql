-- reset
DROP DATABASE IF EXISTS library;
CREATE DATABASE library;
USE library;

-- create books table
CREATE TABLE Books (
	ISBN BIGINT UNIQUE NOT NULL,
	title VARCHAR(40) NOT NULL,
    author VARCHAR(30) NOT NULL,
    stock int NOT NULL,
    
    PRIMARY KEY (ISBN)
);

-- create users table
CREATE TABLE Users (
	user_id int UNIQUE NOT NULL AUTO_INCREMENT,
    First_name VARCHAR(20) NOT NULL,
    Last_name VARCHAR(20) NOT NULL,
    Contact_number VARCHAR(20) NOT NULL,
    Address_1 VARCHAR(30) NOT NULL,
    Address_2 VARCHAR(30),
    County VARCHAR(20) NOT NULL,
    Postcode VARCHAR(20) NOT NULL,
    
    PRIMARY KEY (user_id)
);

-- create loaned table
CREATE TABLE Loaned (
	user_id int NOT NULL,
    ISBN BIGINT NOT NULL,
    date_lent DATE NOT NULL,
    due_date DATE NOT NULL
);

-- add books to books table
INSERT INTO Books (ISBN, title, author, stock)
VALUES
	(9780446310789, "To Kill a Mockingbird", "Harper Lee", 3),
    (9780345806567, "Giovanni's Room", "James Baldwin", 1),
    (9780747532743, "Harry Potter and the Philosopher's Stone", "J. K. Rowling", 4),
    (9780345816047, "12 Rules for Life: An Antidote to Chaos", "Jordan B. Peterson", 0),
    (9781501132872, "All the Light We Cannot See", "Anthony Doerr", 5),
    (9781913484101, "Guinness World Records 2022", "Guinness World Records", 12),
    (9780241425428, "The Man Who Died Twice", "Richard Osman", 6),
    (9781527244580, "Bodega: Tales from the Bodegaverse", "Edward Forsyth", 0),
    (9798602477429, "You Don't Know JS Yet: Get Started", "Kyle Simpson", 3),
    (9781118008188, "HTML and CSS: Design and Build Websites", "Jon Duckett", 2);

-- add some users with Address_2
INSERT INTO Users (First_name, Last_name, Contact_number, Address_1, Address_2, County, Postcode)
VALUES
	("Brodie", "Gribbs", "+44 7805037746", "4 Fake Fields", "Nottaton", "West Midlands", "B98 5BB"),
    ("Amber", "Swaney", "+44 7782165492", "4 Fake Fields", "Nottaton", "West Midlands", "B98 5BB"),
    ("Joe", "Smith", "+44 7412546662", "25 Smallet Close", "Linkey Heath", "Norfolk", "PE10 5DN"),
    ("Jane", "Dawson", "+44 7489124831", "32D Nipply Court", "Tighton", "Cambridgeshire", "C29 8LP"),
    ("Abby", "Dirch", "+44 7541222225", "46 Nonnington Drive", "King's Green", "Derbyshire", "DE1 4NB"),
    ("Mike", "Rotch", "+44 7451297745", "The Hawthorns, Birch Road", "Chambley", "Derbyshire", "DE4 2GT"),
    ("Anita", "Bath", "+44 7795581243", "4 High Street", "Lingerpool", "Leicestershire", "LE7 5HL");
    
-- add some users without Address_2
INSERT INTO Users (First_name, Last_name, Contact_number, Address_1,  County, Postcode)
VALUES
	("Fergus", "Greggs", "+44 7845032446", "1 Juan Street", "Staffordshire", "ST2 2RA"),
    ("Chester", "Gardner", "+44 7748965571", "71 Wendyl Lane", "Kent", "ST2 2RA"),
    ("Tony", "Bubster", "+44 7696969696", "69 Nixty-sine Close", "Nottinghamshire", "N45 9FR");
    
-- add loaned books
INSERT INTO Loaned (user_id, ISBN, date_lent, due_date)
VALUES
	(1,9781527244580,"22-04-25","22-05-25"),
    (8,9780241425428,"22-04-15","22-05-15"),
    (2,9780345806567,"22-04-12","22-05-12"),
    (9,9798602477429,"22-04-08","22-05-08"), -- past due date
    (5,9780747532743,"22-04-27","22-05-27"),
    (4,9780747532743,"22-04-01","22-05-01"); -- past due date