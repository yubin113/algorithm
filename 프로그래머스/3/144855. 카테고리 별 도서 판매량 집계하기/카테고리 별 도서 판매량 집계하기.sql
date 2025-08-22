-- 코드를 입력하세요
SELECT b.category as CATEGORY, sum(s.sales) as TOTAL_SALES
from book b join book_sales s on b.book_id = s.book_id
where MONTH(s.sales_date) = 1 and year(s.sales_date) = 2022
group by b.category
order by b.category