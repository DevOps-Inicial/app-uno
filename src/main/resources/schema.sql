/* Table Employees */
CREATE TABLE icei.g_employees(
    employee_id uuid PRIMARY KEY DEFAULT uuid_generate_v4() UNIQUE NOT NULL,
    first_name varchar(45) NOT NULL,
    last_name varchar(45) NOT NULL,
    email varchar(50) NOT NULL,
    address varchar(200) NOT NULL,
    cell_phone varchar(15) NOT NULL,
    enabled boolean NOT NULL DEFAULT TRUE
);
/*Tabla GUsers */
CREATE TABLE icei.g_users(
    user_id uuid PRIMARY KEY DEFAULT uuid_generate_v4() UNIQUE NOT NULL,
    user_name varchar(20) NOT NULL,
    email varchar(50) NOT NULL,
    password varchar(150) NOT NULL,
    enabled boolean NOT NULL DEFAULT TRUE
);

/* Tabla GRoles */
CREATE TABLE icei.g_roles(
    role_id uuid PRIMARY KEY DEFAULT uuid_generate_v4() UNIQUE NOT NULL,
    name varchar(20) NOT NULL,
    enabled boolean NOT NULL DEFAULT TRUE,
    created_by_user varchar(255) NOT NULL,
    created_date timestamp NOT NULL,
    last_modified_by_user varchar(255) NOT NULL,
    last_modified_date timestamp NOT NULL,
    number_of_modifications bigint NOT NULL
);

/* Tabla G_Users_Roles */
CREATE TABLE icei.g_user_roles(
    user_role_id uuid PRIMARY KEY DEFAULT uuid_generate_v4() UNIQUE NOT NULL,
    user_id uuid references icei.g_users(user_id),
    role_id uuid references icei.g_roles(role_id)
);
