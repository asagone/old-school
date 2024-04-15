<p align="center">
  <img src="https://cdn-icons-png.flaticon.com/512/5968/5968517.png" width="200">
</p>

<h3 align="center">OLD SCHOOL</h3>

<div align="center">

[![Status](https://img.shields.io/badge/status-active-success.svg)](https://github.com/asagone/old-school) 
[![GitHub Pull Requests](https://img.shields.io/github/issues-pr/anttoniogn-dev/next-template.svg)](https://github.com/asagone/old-school)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](/LICENSE)

</div>

> [!NOTE]\
> Project that acts as a platform for accessing and managing student grades.

> [!IMPORTANT]\
> In development.

### Usage
> Use the development branch `branch/dev`
```bash
git clone https://github.com/asagone/old-school.git

cd old-school

git checkout branch/dev
```

#### Front-end
> Node version 20 or higher.
```bash
cd front-end

npm install

npm run dev
```

#### Back-end
> Use docker and docker-compose.
```bash
cd back-end

docker-compose up -d

mvn spring-boot:run
```


| Route | Usage
| --- | --- |
| **GET: /students** | Get all students |
| **POST: /students** | Register a student |
| **PUT: /students/update/:registration** | Update a student |
| **DELETE: /students/delete/:registration** | Delete a student with a name |

##### Examples:
> Thunder client or Insomnia - POST:
```json
{
  "registration": 3,
  "studentName": "Student",
  "averageGrade": 0,
  "englishGrade": 10,
  "portugueseGrade": 9,
  "japaneseGrade": 7
}
```