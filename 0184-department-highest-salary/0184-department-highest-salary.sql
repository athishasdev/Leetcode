SELECT d.name AS Department,
       e.name AS Employee,
       t.salary AS Salary
FROM department d
JOIN (
    SELECT departmentid,
           MAX(salary) AS salary
    FROM employee
    GROUP BY departmentid
)t
ON d.id = t.departmentid
JOIN employee e
ON e.salary = t.salary 
AND e.departmentid = t.departmentid