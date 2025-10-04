CREATE TABLE IF NOT EXITS time_deposits (
    time_deposit_id SERIAL PRIMARY KEY,
    plan_type VARCHAR(50) NOT NULL,
    days INT NOT NULL,
    balance DECIMAL(15,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS withdrawals (
    withdrawal_id SERIAL PRIMARY KEY,
    time_deposit_id INT NOT NULL REFERENCES time_deposits(time_deposit_id),
    amount DECIMAL(15,2) NOT NULL,
    date DATE NOT NULL
);
