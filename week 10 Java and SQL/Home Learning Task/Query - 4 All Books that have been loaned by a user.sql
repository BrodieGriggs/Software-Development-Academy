USE library;

SELECT Books.ISBN, Books.title, Books.author FROM Books
INNER JOIN Loaned ON Books.ISBN = Loaned.ISBN;