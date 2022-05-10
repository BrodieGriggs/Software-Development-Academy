USE library;

SELECT
	Users.user_id,
    Users.First_name,
    Users.Last_name,
    Books.title, Books.author,
    Books.ISBN,
    Loaned.date_lent,
    Loaned.due_date
FROM Users
INNER JOIN Loaned ON Users.user_id = Loaned.user_id
INNER JOIN Books ON Loaned.ISBN = Books.ISBN
WHERE Loaned.due_date < CURDATE();