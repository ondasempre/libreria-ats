package com.ats.idgenerator;

import com.ats.architecture.dao.DAOException;

public interface IdGeneratorInterface {
	long getNextId() throws DAOException, ClassNotFoundException;
}
