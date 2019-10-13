select COUNT(country)
from   (SELECT Country FROM CUStomers group by Country);


select CutomerID
from   Customers
group by Country

select name from Employee order by name ASC;

elect name from Employee where salary>2000 and months <10 order by employee_id asc;

select COUNT(ID)
from CITY
where POPULATION>100000;

select SUM(POPULATION)
from CITY
where DISTRICT = 'California';

select AVG(POPULATION)
from CITY
where DISTRICT='California';

select rounddown(AVG(POPULATION))
from CITY
where DISTRICT= 'California';
