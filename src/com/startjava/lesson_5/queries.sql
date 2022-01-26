-- выведите всю таблицу
SELECT * FROM Jaegers;

-- отобразите только не уничтоженных роботов
SELECT * FROM Jaegers WHERE status != 'Destroyed';

-- отобразите роботов нескольких серий, например Mark-1 и Mark-6
SELECT * FROM Jaegers WHERE mark = 'Mark-1' OR mark = 'Mark-6';

-- отсортируйте таблицу по убыванию по столбцу mark
SELECT * FROM Jaegers ORDER BY mark;
SELECT * FROM Jaegers ORDER BY mark DESC;

-- отобразите самого старого робота
SELECT * FROM Jaegers WHERE launch = (SELECT MAX(launch) FROM Jaegers);

-- отобразите роботов, которые уничтожили больше/меньше всех kaiju
SELECT * FROM Jaegers WHERE kaijuKill = (SELECT MAX(kaijuKill) FROM Jaegers);
SELECT * FROM Jaegers WHERE kaijuKill = (SELECT MIN(kaijuKill) FROM Jaegers);

-- отобразите средний вес роботов
SELECT AVG(weight) FROM Jaegers;

-- увеличьте на единицу количество уничтоженных kaiju у роботов, которые до сих пор не разрушены
SELECT * FROM Jaegers WHERE status != 'Destroyed';
UPDATE Jaegers
    SET kaijuKill = kaijuKill + 1
    WHERE status != 'Destroyed';
SELECT * FROM Jaegers WHERE status != 'Destroyed';

-- удалите уничтоженных роботов
DELETE FROM Jaegers WHERE status = 'Destroyed';