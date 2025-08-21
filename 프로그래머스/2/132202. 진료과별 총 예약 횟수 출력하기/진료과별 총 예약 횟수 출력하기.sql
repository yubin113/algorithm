-- 코드를 입력하세요
SELECT mcdp_cd as "진료과 코드", count(mcdp_cd) as "5월예약건수"
from appointment
where month(apnt_ymd) = 5 and year(apnt_ymd) = 2022
group by mcdp_cd
order by count(mcdp_cd), mcdp_cd;