create database newSchool;
use newSchool;
## 建表
CREATE TABLE students
(
    sno       VARCHAR(3) NOT NULL,
    sname     VARCHAR(4) NOT NULL,
    ssex      VARCHAR(2) NOT NULL,
    sbirthday DATETIME,
    class     VARCHAR(5)
);

CREATE TABLE courses
(
    cno   VARCHAR(5)  NOT NULL,
    cname VARCHAR(10) NOT NULL,
    tno   VARCHAR(10) NOT NULL
);

CREATE TABLE scores
(
    sno    VARCHAR(3)     NOT NULL,
    cno    VARCHAR(5)     NOT NULL,
    degree NUMERIC(10, 1) NOT NULL
);

CREATE TABLE teachers
(
    tno       VARCHAR(3)  NOT NULL,
    tname     VARCHAR(4)  NOT NULL,
    tsex      VARCHAR(2)  NOT NULL,
    tbirthday DATETIME    NOT NULL,
    prof      VARCHAR(6),
    depart    VARCHAR(10) NOT NULL
);

## 插入数据
INSERT INTO STUDENTS (SNO, SNAME, SSEX, SBIRTHDAY, CLASS)
VALUES (108, '曾华', '男', '1977-09-01', 95033);
INSERT INTO STUDENTS (SNO, SNAME, SSEX, SBIRTHDAY, CLASS)
VALUES (105, '匡明', '男', '1975-10-02', 95031);
INSERT INTO STUDENTS (SNO, SNAME, SSEX, SBIRTHDAY, CLASS)
VALUES (107, '王丽', '女', '1976-01-23', 95033);
INSERT INTO STUDENTS (SNO, SNAME, SSEX, SBIRTHDAY, CLASS)
VALUES (101, '李军', '男', '1976-02-20', 95033);
INSERT INTO STUDENTS (SNO, SNAME, SSEX, SBIRTHDAY, CLASS)
VALUES (109, '王芳', '女', '1975-02-10', 95031);
INSERT INTO STUDENTS (SNO, SNAME, SSEX, SBIRTHDAY, CLASS)
VALUES (103, '陆君', '男', '1974-06-03', 95031);

INSERT INTO COURSES(CNO, CNAME, TNO)
VALUES ('3-105', '计算机导论', 825);
INSERT INTO COURSES(CNO, CNAME, TNO)
VALUES ('3-245', '操作系统', 804);
INSERT INTO COURSES(CNO, CNAME, TNO)
VALUES ('6-166', '数据电路', 856);
INSERT INTO COURSES(CNO, CNAME, TNO)
VALUES ('9-888', '高等数学', 100);

INSERT INTO SCORES(SNO, CNO, DEGREE)
VALUES (103, '3-245', 86);
INSERT INTO SCORES(SNO, CNO, DEGREE)
VALUES (105, '3-245', 75);
INSERT INTO SCORES(SNO, CNO, DEGREE)
VALUES (109, '3-245', 68);
INSERT INTO SCORES(SNO, CNO, DEGREE)
VALUES (103, '3-105', 92);
INSERT INTO SCORES(SNO, CNO, DEGREE)
VALUES (105, '3-105', 88);
INSERT INTO SCORES(SNO, CNO, DEGREE)
VALUES (109, '3-105', 76);
INSERT INTO SCORES(SNO, CNO, DEGREE)
VALUES (101, '3-105', 64);
INSERT INTO SCORES(SNO, CNO, DEGREE)
VALUES (107, '3-105', 91);
INSERT INTO SCORES(SNO, CNO, DEGREE)
VALUES (108, '3-105', 78);
INSERT INTO SCORES(SNO, CNO, DEGREE)
VALUES (101, '6-166', 85);
INSERT INTO SCORES(SNO, CNO, DEGREE)
VALUES (107, '6-106', 79);
INSERT INTO SCORES(SNO, CNO, DEGREE)
VALUES (108, '6-166', 81);

INSERT INTO TEACHERS(TNO, TNAME, TSEX, TBIRTHDAY, PROF, DEPART)
VALUES (804, '李诚', '男', '1958-12-02', '副教授', '计算机系');
INSERT INTO TEACHERS(TNO, TNAME, TSEX, TBIRTHDAY, PROF, DEPART)
VALUES (856, '张旭', '男', '1969-03-12', '讲师', '电子工程系');
INSERT INTO TEACHERS(TNO, TNAME, TSEX, TBIRTHDAY, PROF, DEPART)
VALUES (825, '王萍', '女', '1972-05-05', '助教', '计算机系');
INSERT INTO TEACHERS(TNO, TNAME, TSEX, TBIRTHDAY, PROF, DEPART)
VALUES (831, '刘冰', '女', '1977-08-14', '助教', '电子工程系');


## 展示表
show tables;
## 展示全部数据
select *
from courses c;
select *
from scores s;
select *
from students s;
select *
from teachers t;

## 查询操作
#
# 1.查询Students表中的所有记录的Sname、Ssex和Class列。
select sname, ssex, class
from students s;

# 2.查询教师所有的单位即不重复的Depart列。
select distinct depart
from teachers t;
#
# 3.查询Student表的所有记录。
select *
from students s;

# 4.查询Score表中成绩在60到80之间的所有记录。

select degree
from scores s
where degree between 60 and 80;
# 5.查询Score表中成绩为85，86或88的记录。

select degree
from scores s
where degree in (85, 86, 88);
# 6.查询Student表中“95031”班或性别为“女”的同学记录。
select *
from students s
where s.ssex = '女'
   or s.class = 95031;
# 7.以Class降序查询Student表的所有记录。
##降序是 desc
select *
from students s
order by class desc;

# 8.以Cno升序、Degree降序查询Score表的所有记录。
##升序是 asc  ,多个规则时使用逗号分隔
select *
from scores s
order by cno asc, degree desc;
# 9.查询“95031”班的学生人数。
select count(*)
from students s
where s.class = 95031;

# 10.查询Score表中的最高分的学生学号和课程号。

select s.sno, s.cno
from scores s
where s.degree = (select max(degree) from scores);
# 11.查询‘3-105’号课程的平均分。
select avg(degree)
from scores s
where s.cno = '3-105';

# 12.查询Score表中至少有5名学生选修的并以3开头的课程的平均分数。

select avg(degree)
from scores s
where cno like '3%'
group by cno
having count(cno) >= 5;


# 13.查询最低分大于70，最高分小于90的Sno列。

select sno
from scores s
group by sno
having min(s.degree) > 70
   and max(s.degree) < 90;

# 14.查询所有学生的Sname、Cno和Degree列。

#内连接就是表间的主键与外键相连，只取得键值一致的，可以获取双方表中的数据连接方式。语法如下：
#SELECT 列名1,列名2... FROM 表1 INNER JOIN 表2 ON 表1.外键=表2.主键 WhERE 条件语句;
select sname, cno, degree
from students s
         join scores s2 on s.sno = s2.sno;

# 15.查询所有学生的Sno、Cname和Degree列。
select sno, cname, degree
from scores s
         join courses c on s.cno = c.cno;

# 16.查询所有学生的Sname、Cname和Degree列。

select sname, cname, degree
from students s
         join scores s2 on s.sno = s2.sno
         join courses c on s2.cno = c.cno;

# 17.查询“95033”班所选课程的平均分。
select avg(degree)
from scores s,
     students s2
where s.sno = s2.sno
  and s2.class = 95033
group by cno;


# 18.假设使用如下命令建立了一个grade表：
CREATE TABLE grade
(
    low  TINYINT,
    upp  TINYINT,
    rank CHAR(1)
);
INSERT INTO grade
VALUES (90, 100, 'A');
INSERT INTO grade
VALUES (80, 89, 'B');
INSERT INTO grade
VALUES (70, 79, 'C');
INSERT INTO grade
VALUES (60, 69, 'D');
INSERT INTO grade
VALUES (0, 59, 'E');
# 现查询所有同学的Sno、Cno和rank列。

select sno, cno, degree, rank
from grade g
         join scores s on s.degree between g.low and g.upp;


# 19.查询选修“3-105”课程的成绩高于“109”号同学成绩的所有同学的记录。

select *
from students s,
     scores s2
where s2.cno = '3-105'
  and s.sno = s2.sno
  and s2.degree >
      (select degree from scores s3 where s3.cno = '3-105' and s3.sno = 109);
# 20.查询score中选学一门以上课程的同学中分数为非最高分成绩的记录。
#分析: 选多门课程  select * from  scores s group by sno having  count(*)>1;
#如果这边使用的*选择,会报错,因为前面选择的内容只能选 group by 中的
# select * from  scores s group by sno having  count(*)>1;
select *
from scores s
where degree < (select max(degree) from scores s2 where s.cno = s2.cno)
  and sno in (select sno from scores s3 group by sno having count(*) > 1);


# 21.查询成绩高于学号为“109”、课程号为“3-105”的成绩的所有记录。
#分析:学号为 109,课程号为 3-105 的成绩
# select degree from scores s where s.sno=109 and s.cno='3-105';

select *
from scores s,
     students s2
where s.sno = s2.sno
  and s.degree > (select degree from scores s where s.sno = 109 and s.cno = '3-105');

# 22.查询和学号为107的同学同年出生的所有学生的Sno、Sname和Sbirthday列。
# 分析 学号为 107 的同学的出生年  select YEAR('2018-07-06'); -- 获取日期的年份
# select year(sbirthday) from students s where s.sno=107;

select sno, sname, sbirthday
from students s
where year(s.sbirthday) = (select year(sbirthday) from students s2 where s2.sno = 107);

# 23.查询“张旭“教师任课的学生成绩。
#分析: 教师张旭的表 teachers 包含 tno
#       关联表  tno courses  cno
#       关联表  cno scores   degree

select sno, s.cno, degree
from teachers t,
     courses c,
     scores s
where t.tname = '张旭'
  and t.tno = c.tno
  and c.cno = s.cno;

# 另一种写法 select Sno,Cno,Degree from Scores where Cno in (select Cno from Courses where Tno in (select Tno from Teachers where Tname='张旭'))

# 24.查询选修某课程的同学人数多于5人的教师姓名。
#分析:选修课程的同学数
select cno
from scores s
group by cno
having count(cno) > 5;
#通过 cno 链接到 cources ,再通过 tno 找到老师
select distinct t.tname
from teachers t,
     courses c,
     scores s
where t.tno = c.tno
  and c.cno in (select cno from scores group by cno having count(cno) > 5);

# 25.查询95033班和95031班全体学生的记录。
select *
from students s
where s.class = 95033
   or s.class = 95031;

# 26.查询存在有85分以上成绩的课程Cno.
select distinct s.cno
from scores s
where s.degree > 85;

# 27.查询出“计算机系“教师所教课程的成绩表。
#分析:计算机系 这是 teacher 的 depart ,再通过 cource 连接到 scores
#将上面顺序翻过来
select s.degree, t.tname, c.cname
from scores s,
     courses c,
     teachers t
where s.cno = c.cno
  and t.tno = c.tno
  and t.depart in (select t2.depart from teachers t2 where t2.depart = '计算机系');



# 28.查询“计算机系”与“电子工程系“不同职称的教师的Tname和Prof。


#这个语句有点看不懂
select tname, prof
from teachers t
where prof not in (select prof from teachers t2 where t.depart != t2.depart);

#正常语句
select *
from teachers t
where prof not in (select distinct prof
                   from teachers t2
                   where t2.depart = '计算机系'
                     and t2.prof in
                         (select distinct t3.prof from teachers t3 where t3.depart = '电子工程系'));

# 29.查询选修编号为“3-105“课程且成绩至少高于任意选修编号为“3-245”的同学的成绩的Cno、Sno和Degree,并按Degree从高到低次序排序。

select cno, sno, degree
from scores s
where s.cno = '3-105'
  and s.degree > (select min(degree) from scores s2 where s2.cno = '3-245')
order by s.degree desc;
#可以使用 any 关键词
select *
from Scores
where Cno = '3-105'
  and Degree > any (select Degree from Scores where Cno = '3-245')
order by degree desc;


# 30.查询选修编号为“3-105”且成绩高于所有选修编号为“3-245”课程的同学的Cno、Sno和Degree.
select cno, sno, degree
from scores s
where s.cno = '3-105'
  and s.degree > (select max(degree) from scores s2 where s2.cno = '3-245');


# 31.查询所有教师和同学的name、sex和birthday.

# 分析:这种方法不对,会生成笛卡尔积 select * from students s,teachers t ;
#使用 union 关键字来合并两端查询内容
select t.tname, t.tsex, t.tbirthday
from teachers t

union
select s.sname, s.ssex, s.sbirthday
from students s;


# 32.查询所有“女”教师和“女”同学的name、sex和birthday.
# 分析:这种方法不对,会生成笛卡尔积 select * from students s,teachers t where s.ssex='nv' or t.tsex='女';
#使用 union 关键字来合并两端查询内容
select t.tname, t.tsex, t.tbirthday
from teachers t
where t.tsex = '女'
union
select s.sname, s.ssex, s.sbirthday
from students s
where s.ssex = '女';

# 33.查询成绩比该课程平均成绩低的同学的成绩表。
# 分析: 查找平均成绩 select avg(s2.degree) from scores s2;
select *
from scores s
where s.degree < (select avg(s2.degree) from scores s2);

# 34.查询所有任课教师的Tname和Depart.
select distinct tname, depart
from teachers t,
     courses c,
     scores s
where t.tname in (select distinct t2.tname
                  from teachers t2,
                       scores s2,
                       courses c2
                  where t2.tno = c2.tno
                    and c2.cno = s2.cno);

# 35.查询所有未讲课的教师的Tname和Depart.

#分析:课程编号  not in  scores 的课程号 双重认证,一个是不在

select distinct tname, depart
from teachers t,
     courses c,
     scores s
where t.tname not in (select distinct t2.tname
                      from teachers t2,
                           scores s2,
                           courses c2
                      where t2.tno = c2.tno
                        and c2.cno = s2.cno);


# 36.查询至少有2名男生的班号。

select class
from students s
group by class
having count(ssex = '男') > 1;


select Class
FROM students
where Ssex = '男'
group by Class
having COUNT(*) > 1;

# 37.查询Student表中不姓“王”的同学记录。

select *
from students s
where s.sname not like '王%';

# 38.查询Student表中每个学生的姓名和年龄。

select sname, (year(now()) - year(sbirthday)) '年龄'
from students s;
# 39.查询Student表中最大和最小的Sbirthday日期值。

#这边判断的日期大小是反的,生日数字越小的,年龄越大
select max(sbirthday) '最小', min(sbirthday) '最大'
from students s;
# 40.以班号和年龄从大到小的顺序查询Student表中的全部记录。


# 41.查询“男”教师及其所上的课程。
select Tname, Cname
from Teachers,
     Courses
where Tsex = '男'
  and Teachers.Tno = Courses.Tno;
#这个还判断其是否真的授课了
select t3.tname, c3.cname
from courses c3,
     teachers t3
where t3.tsex = '男'
  and c3.tno = t3.tno
  and t3.tname in (select distinct tname
                   from teachers t,
                        courses c,
                        scores s
                   where t.tname in (select distinct t2.tname
                                     from teachers t2,
                                          scores s2,
                                          courses c2
                                     where t2.tno = c2.tno
                                       and c2.cno = s2.cno));


# 42.查询最高分同学的Sno、Cno和Degree列。

select sno, cno, degree
from scores s
where degree = (select max(degree) from scores s2);

select *
from scores s
order by Degree desc
limit 1;

# 43.查询和“李军”同性别的所有同学的Sname.

select sname
from students s
where s.ssex = (select s2.ssex from students s2 where s2.sname = '李军')
  and s.sname != '李军';

#
# 44.查询和“李军”同性别并同班的同学Sname.

select sname
from students s
where s.ssex = (select s2.ssex from students s2 where s2.sname = '李军')
  and s.class = (select s3.class from students s3 where s3.sname = '李军')
  and s.sname != '李军';

# 45.查询所有选修“计算机导论”课程的“男”同学的成绩表
select *
from students s,
     courses c,
     scores s2
where s.sno = s2.sno
  and c.cno = s2.cno
  and c.cname = '计算机导论'
  and s.ssex = '男';

#时间计算 datediff
#adddate
select datediff(now(), '2017-9-9');
select datediff(now(), '2019-11-30');
select adddate(now(), 1000);