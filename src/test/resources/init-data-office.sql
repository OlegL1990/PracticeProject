DELETE FROM Office;

DELETE  FROM Org;

INSERT INTO Org ( id, version, name, full_name, inn, kpp,address, phone, is_active) VALUES
(1, 0, 'Name', 'FullName', '12345','12345','Address','88888', true);

INSERT INTO Office ( id, version, name, address, phone, is_active, org_id) VALUES
(1, 0, 'Name', 'Address','88888', true,1);




