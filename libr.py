from lxml import etree

tree = etree.parse("libr.xml")
books = tree.findall("book")

total_price = 0
count = 0
print("Книги в библиотеке:")
for book in books:
    title = book.findtext("title")
    author = book.findtext("author")
    year = book.findtext("year")
    genre = book.findtext("genre")
    price = float(book.findtext("price"))
    print(f"{title} by {author} ({year}) - {genre}, ${price:.2f}")
    total_price += price
    count += 1
if count > 0:
    print(f"\nСредняя цена книг: ${total_price / count:.2f}")
else:
    print("\nВ библиотеке нет книг!")
target_genre = "Fantasy"
print(f"\nКниги в жанре '{target_genre}':")
for book in books:
    if book.findtext("genre") == target_genre:
        print(book.findtext("title"))
