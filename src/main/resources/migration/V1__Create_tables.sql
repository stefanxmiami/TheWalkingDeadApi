-- Simplified characters table with id as the sole primary key
CREATE TABLE IF NOT EXISTS "characters"
(
    id               SERIAL PRIMARY KEY,
    name             VARCHAR(255) NOT NULL,
    status           VARCHAR(100),
    first_appearance VARCHAR(255),
    description      TEXT
);

-- Ensure uniqueness for character names
ALTER TABLE characters
    ADD CONSTRAINT unique_name UNIQUE (name);

-- Table for storing memorable quotes
CREATE TABLE IF NOT EXISTS "character_memorable_quotes"
(
    id           SERIAL PRIMARY KEY,
    character_id INTEGER NOT NULL REFERENCES characters (id),
    quote        TEXT NOT NULL
);

-- Detail table referencing characters
CREATE TABLE IF NOT EXISTS "character"
(
    id                        INTEGER PRIMARY KEY REFERENCES characters (id) ON DELETE CASCADE,
    age                       INTEGER,
    awards                    VARCHAR(255),
    description               VARCHAR(255),
    ethnicity                 VARCHAR(255),
    family_members            VARCHAR(1000),
    fan_rating                DOUBLE PRECISION,
    first_appearance          VARCHAR(255),
    gender                    VARCHAR(255),
    group_affiliation         VARCHAR(255),
    image_url                 VARCHAR(255),
    last_appearance           VARCHAR(255),
    name                      VARCHAR(255),
    narrative_role            VARCHAR(255),
    occupation                VARCHAR(255),
    personality_traits        VARCHAR(255),
    physical_description      VARCHAR(255),
    significant_relationships VARCHAR(255),
    status                    VARCHAR(255),
    total_screen_time         INTEGER
);
