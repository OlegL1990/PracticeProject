DELETE FROM Employee;

DELETE FROM Office;

DELETE  FROM Org;

INSERT INTO Org ( id, version, name, full_name, inn, kpp,address, phone, is_active) VALUES
(1, 0, 'Name', 'FullName', '12345','12345','Address','88888', true);

INSERT INTO Office ( id, version, name, address, phone, is_active, org_id) VALUES
(1, 0, 'Name', 'Address','88888', true,1);

INSERT INTO Employee(id, version, first_name,second_name, middle_name, position, phone, doc_code, doc_number, citizenship_code,is_identified,office_id) VALUES
(1, 0, 'FirstName', 'SeName', 'MiddleName','Position','88888',10,'12345',643, true,1);