-- 코드를 입력하세요
SELECT animal_id, name, CASE 
        WHEN sex_upon_intake LIKE 'Neutered%' THEN 'O'
        WHEN sex_upon_intake LIKE 'Spayed%' THEN 'O'
        ELSE 'X'
    END AS 중성화
from animal_ins
order by animal_id
