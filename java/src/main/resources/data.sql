-- Seed deposits data
INSERT INTO time_deposits (time_deposit_id, plan_type, days, balance)
VALUES
  (1, 'basic', 45, 1000.00),
  (2, 'student', 200, 5000.00),
  (3, 'premium', 60, 10000.00);

-- Seed withdrawals data
INSERT INTO withdrawals (withdrawal_id, time_deposit_id, amount, date) VALUES
  (1, 1, 100.00, '2024-01-01'),
  (2, 2, 50.00, '2024-02-01'),
  (3, 3, 200.00, '2024-03-01');
