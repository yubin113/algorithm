-- 코드를 입력하세요
# SELECT category, max(price) as max_price, product_name
# from food_product 
# group by category
# having category in ('과자','국','김치','식용유')
# order by price desc

SELECT
    f.CATEGORY,
    t.MAX_PRICE,
    f.PRODUCT_NAME
FROM
    FOOD_PRODUCT f
    INNER JOIN (
        SELECT CATEGORY, MAX(PRICE) AS MAX_PRICE
        FROM FOOD_PRODUCT
        WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
        GROUP BY CATEGORY
        ) AS t
    ON f.CATEGORY = t.CATEGORY
    AND f.PRICE = t.MAX_PRICE
ORDER BY
    PRICE DESC;