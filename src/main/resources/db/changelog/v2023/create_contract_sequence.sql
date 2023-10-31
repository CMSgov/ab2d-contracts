CREATE SEQUENCE IF NOT EXISTS contract.contract_seq START 1 INCREMENT BY 50;

select setval('contract.contract_seq', (SELECT MAX(id) FROM contract.contract));
ALTER TABLE contract.contract ALTER COLUMN id SET DEFAULT nextval('contract.contract_seq');