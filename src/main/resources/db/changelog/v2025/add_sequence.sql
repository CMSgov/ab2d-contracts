CREATE SEQUENCE IF NOT EXISTS contract.contract_seq START 1 INCREMENT BY 50;
SELECT setval('contract.contract_seq', COALESCE((SELECT MAX(id) FROM contract.contract), 1), true);
ALTER TABLE contract.contract ALTER COLUMN id SET DEFAULT nextval('contract.contract_seq');
