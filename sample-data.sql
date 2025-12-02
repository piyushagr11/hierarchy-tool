-- Sample Data for Supply Chain Hierarchy

-- 1. Vehicle Types
INSERT INTO vehicle_type (name) VALUES ('Car');
INSERT INTO vehicle_type (name) VALUES ('Truck');
INSERT INTO vehicle_type (name) VALUES ('Motorcycle');
INSERT INTO vehicle_type (name) VALUES ('SUV');

-- 2. Brands
INSERT INTO brand (name, description) VALUES ('Toyota', 'Japanese multinational automotive manufacturer');
INSERT INTO brand (name, description) VALUES ('Honda', 'Japanese public multinational conglomerate');
INSERT INTO brand (name, description) VALUES ('Ford', 'American multinational automobile manufacturer');
INSERT INTO brand (name, description) VALUES ('Hyundai', 'South Korean multinational automotive manufacturer');
INSERT INTO brand (name, description) VALUES ('Harley-Davidson', 'American motorcycle manufacturer');

-- 3. Brand - Vehicle Type Mappings
-- Toyota makes Cars, Trucks, SUVs
INSERT INTO brand_vehicle_type (brand_id, vehicle_type_id) VALUES 
((SELECT id FROM brand WHERE name = 'Toyota'), (SELECT id FROM vehicle_type WHERE name = 'Car')),
((SELECT id FROM brand WHERE name = 'Toyota'), (SELECT id FROM vehicle_type WHERE name = 'Truck')),
((SELECT id FROM brand WHERE name = 'Toyota'), (SELECT id FROM vehicle_type WHERE name = 'SUV'));

-- Honda makes Cars, Motorcycles
INSERT INTO brand_vehicle_type (brand_id, vehicle_type_id) VALUES 
((SELECT id FROM brand WHERE name = 'Honda'), (SELECT id FROM vehicle_type WHERE name = 'Car')),
((SELECT id FROM brand WHERE name = 'Honda'), (SELECT id FROM vehicle_type WHERE name = 'Motorcycle'));

-- Ford makes Cars, Trucks
INSERT INTO brand_vehicle_type (brand_id, vehicle_type_id) VALUES 
((SELECT id FROM brand WHERE name = 'Ford'), (SELECT id FROM vehicle_type WHERE name = 'Car')),
((SELECT id FROM brand WHERE name = 'Ford'), (SELECT id FROM vehicle_type WHERE name = 'Truck'));

-- Harley makes Motorcycles
INSERT INTO brand_vehicle_type (brand_id, vehicle_type_id) VALUES 
((SELECT id FROM brand WHERE name = 'Harley-Davidson'), (SELECT id FROM vehicle_type WHERE name = 'Motorcycle'));

-- 4. Vehicle Models
INSERT INTO vehicle_model (name, year, variant, brand_id) VALUES 
('Camry', 2020, 'Petrol', (SELECT id FROM brand WHERE name = 'Toyota')),
('Camry', 2020, 'Hybrid', (SELECT id FROM brand WHERE name = 'Toyota')),
('Hilux', 2021, 'Diesel', (SELECT id FROM brand WHERE name = 'Toyota')),
('Civic', 2019, 'Petrol', (SELECT id FROM brand WHERE name = 'Honda')),
('F-150', 2022, 'Diesel', (SELECT id FROM brand WHERE name = 'Ford')),
('i20', 2021, 'Manual', (SELECT id FROM brand WHERE name = 'Hyundai'));

-- 5. Part Types
INSERT INTO part_type (name, description) VALUES ('Filters', 'Air, Oil, and Fuel filters');
INSERT INTO part_type (name, description) VALUES ('Brake System', 'Pads, Discs, Calipers');
INSERT INTO part_type (name, description) VALUES ('Engine Parts', 'Spark plugs, Belts, Pistons');

-- 6. Auto Parts
INSERT INTO auto_part (part_number, name, description, manufacturer, part_type_id) VALUES 
('FLT-12345', 'Premium Oil Filter', 'High performance oil filter', 'Bosch', (SELECT id FROM part_type WHERE name = 'Filters')),
('BRK-67890', 'Ceramic Brake Pads', 'Low dust ceramic pads', 'Brembo', (SELECT id FROM part_type WHERE name = 'Brake System')),
('ENG-11111', 'Iridium Spark Plugs', 'Long life spark plugs', 'NGK', (SELECT id FROM part_type WHERE name = 'Engine Parts'));

-- 7. Brand Compatibility
-- Oil Filter fits Toyota and Honda
INSERT INTO brand_part_compatibility (brand_id, auto_part_id, notes) VALUES 
((SELECT id FROM brand WHERE name = 'Toyota'), (SELECT id FROM auto_part WHERE part_number = 'FLT-12345'), 'All models 2015+'),
((SELECT id FROM brand WHERE name = 'Honda'), (SELECT id FROM auto_part WHERE part_number = 'FLT-12345'), 'All models 2015+');

-- Brake Pads fit Hyundai
INSERT INTO brand_part_compatibility (brand_id, auto_part_id, notes) VALUES 
((SELECT id FROM brand WHERE name = 'Hyundai'), (SELECT id FROM auto_part WHERE part_number = 'BRK-67890'), 'i-series only');

-- 8. Model Compatibility
-- Oil Filter fits specific Camry and Civic models
INSERT INTO model_part_compatibility (vehicle_model_id, auto_part_id, notes) VALUES 
((SELECT id FROM vehicle_model WHERE name = 'Camry' AND variant = 'Petrol'), (SELECT id FROM auto_part WHERE part_number = 'FLT-12345'), 'Standard fit'),
((SELECT id FROM vehicle_model WHERE name = 'Civic'), (SELECT id FROM auto_part WHERE part_number = 'FLT-12345'), 'Standard fit');
