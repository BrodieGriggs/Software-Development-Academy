USE library;

SELECT Users.user_id, Users.First_name, Users.Last_name FROM Users
INNER JOIN Loaned ON Users.user_id = Loaned.user_id;