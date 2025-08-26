INSERT INTO school (name, address, phoneNumber) VALUES ('Bangkok International School', '123 Sukhumvit Rd, Bangkok', '02-123-4567');
INSERT INTO school (name, address, phoneNumber) VALUES ('Chiang Mai English School', '45 Nimmanhaemin Rd, Chiang Mai', '053-987-6543');

INSERT INTO teacher (firstName, lastName, email, phoneNumber, subject) VALUES ('Alice', 'Smith', 'alice.smith@email.com', '081-111-2222', 'Math');
INSERT INTO teacher (firstName, lastName, email, phoneNumber, subject) VALUES ('Bob', 'Johnson', 'bob.johnson@email.com', '081-333-4444', 'English');
INSERT INTO teacher (firstName, lastName, email, phoneNumber, subject) VALUES ('Carol', 'Williams', 'carol.williams@email.com', '081-555-6666', 'Science');

UPDATE school SET principal_id = 1 WHERE id = 1;

INSERT INTO student (studentId, firstName, lastName, email, phoneNumber, grade, school_id) VALUES ('S1001', 'Tom', 'Brown', 'tom.brown@email.com', '082-111-1111', 10, 1);
INSERT INTO student (studentId, firstName, lastName, email, phoneNumber, grade, school_id) VALUES ('S1002', 'Lucy', 'Green', 'lucy.green@email.com', '082-222-2222', 9, 1);
INSERT INTO student (studentId, firstName, lastName, email, phoneNumber, grade, school_id) VALUES ('S2001', 'Jack', 'White', 'jack.white@email.com', '083-333-3333', 10, 2);
INSERT INTO student (studentId, firstName, lastName, email, phoneNumber, grade, school_id) VALUES ('S2002', 'Emma', 'Black', 'emma.black@email.com', '083-444-4444', 9, 2);

INSERT INTO course (name, courseCode, description, credits, teacher_id) VALUES ('Algebra', 'MATH101', 'Basic Algebra Course', 3, 1);
INSERT INTO course (name, courseCode, description, credits, teacher_id) VALUES ('English Literature', 'ENG201', 'English Literature Course', 3, 2);
INSERT INTO course (name, courseCode, description, credits, teacher_id) VALUES ('Physics', 'SCI301', 'Introduction to Physics', 4, 3);
INSERT INTO course (name, courseCode, description, credits, teacher_id) VALUES ('Chemistry', 'SCI302', 'Basic Chemistry Course', 4, 3);