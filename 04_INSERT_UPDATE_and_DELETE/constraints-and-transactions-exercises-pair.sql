-- Write queries to return the following:
-- Make the following changes in the "world" database.

-- 1. Add Superman's hometown, Smallville, Kansas to the city table. The 
-- countrycode is 'USA', and population of 45001. (Yes, I looked it up on 
-- Wikipedia.)
INSERT INTO city (name, district, countrycode, population)
VALUES ('Smallville', 'Kansas', 'USA', 45001);

SELECT *
FROM city
WHERE name = 'Smallville';

-- 2. Add Kryptonese to the countrylanguage table. Kryptonese is spoken by 0.0001
-- percentage of the 'USA' population.
INSERT INTO countrylanguage (language, countrycode, percentage, isofficial)
VALUES ('Kryptonese', 'USA', 0.0001, false);

SELECT*
FROM countrylanguage
WHERE language = 'Kryptonese';

-- 3. After heated debate, "Kryptonese" was renamed to "Krypto-babble", change 
-- the appropriate record accordingly.
UPDATE countrylanguage
SET language = 'Krypto-babble'
WHERE language = 'Kryptonese';

SELECT*
FROM countrylanguage
WHERE language = 'Krypto-babble';

-- 4. Set the US captial to Smallville, Kansas in the country table.
UPDATE country
SET capital = (SELECT id FROM city WHERE name = 'Smallville')
WHERE code = 'USA';

SELECT capital
FROM country
WHERE code = 'USA';

-- 5. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)
DELETE FROM city
WHERE name = 'Smallville';
--No, because it is being linked to capital of USA in the country table (4080) - foreigh key constraint

-- 6. Return the US captial to Washington.
UPDATE country
SET capital = (SELECT id FROM city WHERE name = 'Washington')
WHERE code = 'USA';

-- 7. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)
DELETE FROM city
WHERE name = 'Smallville';
--Yes - because Smallville is not being referenced anymore from country table

-- 8. Reverse the "is the official language" setting for all languages where the
-- country's year of independence is within the range of 1800 and 1972 
-- (exclusive). 
-- (590 rows affected)
UPDATE countrylanguage
SET isofficial = NOT isofficial
WHERE countrycode IN (SELECT code FROM country WHERE country.indepyear >1800 AND country.indepyear < 1972);

SELECT countrylanguage.countrycode, countrylanguage.language, countrylanguage.isofficial
FROM countrylanguage
JOIN country ON countrylanguage.countrycode = country.code
WHERE country.indepyear >1800 AND country.indepyear < 1972 AND countrylanguage.countrycode = 'ALB';

-- 9. Convert population so it is expressed in 1,000s for all cities. (Round to
-- the nearest integer value greater than 0.)
-- (4079 rows affected)
UPDATE city
SET population = round(population / 1000.0);

SELECT name, population
FROM city
LIMIT 5;

-- 10. Assuming a country's surfacearea is expressed in square miles, convert it to 
-- square meters for all countries where French is spoken by more than 20% of the 
-- population.
-- (7 rows affected)
UPDATE country
SET surfacearea = surfacearea/0.00000038610
WHERE code IN (SELECT countrylanguage.countrycode FROM countrylanguage WHERE countrylanguage.percentage > 20 AND countrylanguage.language = 'French');

SELECT country.code, country.surfacearea, countrylanguage.language, countrylanguage.percentage
FROM country
JOIN countrylanguage ON country.code = countrylanguage.countrycode
WHERE countrylanguage.percentage > 20 AND countrylanguage.language = 'French';
