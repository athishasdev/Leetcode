SELECT m.name
FROM employee e
JOIN employee m
ON e.managerid = m.id
GROUP BY e.managerid
HAVING COUNT(*) >= 5;