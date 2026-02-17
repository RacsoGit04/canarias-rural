-- Tabla de Roles
CREATE TABLE roles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    description VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla de Usuarios
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    phone VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active BOOLEAN DEFAULT true
);

-- Tabla intermedia 
CREATE TABLE user_roles (
    user_id INTEGER REFERENCES users(id) ON DELETE CASCADE,
    role_id INTEGER REFERENCES roles(id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, role_id)
);

-- Tabla Perfil proveedor
CREATE TABLE providers (
    user_id INTEGER PRIMARY KEY REFERENCES users(id) ON DELETE CASCADE,
    company_name VARCHAR(150),
    contact_info VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla de Zonas
CREATE TABLE zones (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    island VARCHAR(50) NOT NULL,
    description TEXT,
    -- created para posibles funcionalidades 
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla de Alojamientos
CREATE TABLE accommodations (
    id SERIAL PRIMARY KEY, 
    provider_id INTEGER NOT NULL REFERENCES users(id) ON DELETE CASCADE, 
    zone_id INTEGER REFERENCES zones(id) ON DELETE SET NULL, 
    name VARCHAR(150) NOT NULL, 
    price_per_night DECIMAL(10, 2) NOT NULL, 
    description TEXT, 
    address VARCHAR(255),
    capacity INTEGER NOT NULL DEFAULT 1, 
    is_active BOOLEAN DEFAULT true, 
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Índices
CREATE INDEX idx_accommodations_zone ON accommodations(zone_id); 
CREATE INDEX idx_accommodations_price ON accommodations(price_per_night); 

-- Imágenes de Alojamientos
CREATE TABLE accommodations_images (
    id SERIAL PRIMARY KEY, 
    accommodation_id INTEGER NOT NULL REFERENCES accommodations(id) ON DELETE CASCADE, 
    url VARCHAR(255) NOT NULL, 
    is_main BOOLEAN DEFAULT false, 
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
); 

-- Tabla de Actividades 
CREATE TABLE activities (
    id SERIAL PRIMARY KEY, 
    provider_id INTEGER NOT NULL REFERENCES users(id) ON DELETE CASCADE, 
    zone_id INTEGER REFERENCES zones(id) ON DELETE SET NULL, 
    name VARCHAR(150) NOT NULL, 
    description TEXT, 
    price_per_person DECIMAL(10, 2) NOT NULL, 
    duration_minutes INTEGER,
    is_active BOOLEAN DEFAULT true, 
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla de Reservas (Bookings)
CREATE TABLE bookings (
    id SERIAL PRIMARY KEY, 
    user_id INTEGER NOT NULL REFERENCES users(id), 
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING', 
    total_price DECIMAL(10,2) NOT NULL DEFAULT 0.00, 
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Detalle Reserva - Alojamiento
CREATE TABLE bookings_accommodations (
    id SERIAL PRIMARY KEY, 
    booking_id INTEGER NOT NULL REFERENCES bookings(id) ON DELETE CASCADE, 
    accommodation_id INTEGER NOT NULL REFERENCES accommodations(id), 
    start_date DATE NOT NULL, 
    end_date DATE NOT NULL, 
    price DECIMAL(10, 2) NOT NULL, 
    CONSTRAINT check_dates CHECK (end_date > start_date)
);

-- Detalle Reserva - Actividad
CREATE TABLE bookings_activities (
    id SERIAL PRIMARY KEY, 
    booking_id INTEGER NOT NULL REFERENCES bookings(id) ON DELETE CASCADE, 
    activity_id INTEGER NOT NULL REFERENCES activities(id), 
    activity_date TIMESTAMP NOT NULL, 
    people_count INTEGER NOT NULL DEFAULT 1, 
    price DECIMAL(10,2) NOT NULL
);

-- Reseñas
CREATE TABLE reviews (
    id SERIAL PRIMARY KEY, 
    user_id INTEGER NOT NULL REFERENCES users(id) ON DELETE CASCADE, 
    accommodation_id INTEGER REFERENCES accommodations(id) ON DELETE CASCADE,
    activity_id INTEGER REFERENCES activities(id) ON DELETE CASCADE, 
    rating INTEGER NOT NULL CHECK (rating >= 1 AND rating <=5), 
    comment TEXT, 
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    CONSTRAINT unique_user_accommodation_review UNIQUE (user_id, accommodation_id) 
); 

-- Datos iniciales
INSERT INTO roles (name, description) VALUES
('ROLE_USER', 'Usuario viajero estándar'),
('ROLE_PROVIDER', 'Proveedor de servicios (alojamiento/actividades)'),
('ROLE_ADMIN', 'Administrador de la plataforma');