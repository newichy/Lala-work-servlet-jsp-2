-- create database twoTables
-- use twoTables

CREATE TABLE employee (
  id CHAR(6) PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  age INT NOT NULL,
  dept_id CHAR(3)
);


INSERT INTO employee
  (id, name, age, dept_id)
VALUES
  ('EMP001', '湊 雄輔', 23, 'D01'),
  ('EMP002', '綾部 みゆき', 22, 'D02'),
  ('EMP003', '染谷 翔太', 24, 'D03'),
  ('EMP004', '二階堂 ふみ', 25, 'D04'),
  ('EMP005', '渡辺 哲', 26, 'D01');


SELECT * FROM employee;

CREATE TABLE dept (
  id CHAR(3) PRIMARY KEY,
  name VARCHAR(20) NOT NULL
);

INSERT INTO dept VALUES
('D01', '総務部'),
('D02', '経理部'),
('D03', '営業部'),
('D04', '開発部');

SELECT * FROM dept;


ALTER TABLE employee
ADD
  CONSTRAINT fk_dept_id
  FOREIGN KEY (dept_id) REFERENCES dept (id);


-- 修正時刻: Fri 2023/07/14 18:48:36
