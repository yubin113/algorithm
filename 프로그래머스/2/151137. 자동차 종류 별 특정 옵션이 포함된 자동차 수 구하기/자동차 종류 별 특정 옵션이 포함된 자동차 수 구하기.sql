-- 코드를 입력하세요
SELECT CAR_TYPE, count(car_id) AS CARS
from CAR_RENTAL_COMPANY_CAR
where options regexp ('통풍시트|열선시트|가죽시트')
group by car_type
ORDER BY CAR_TYPE;
