-- 코드를 입력하세요
SELECT b.author_id, a.author_name, b.category, sum(b.price * s.sales) as total_sales
from book b join author a on b.author_id = a.author_id
            join book_sales s on b.book_id = s.book_id
where year(s.sales_date) = 2022 and month(s.sales_date) = 1
group by a.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY
order by b.author_id, b.category desc