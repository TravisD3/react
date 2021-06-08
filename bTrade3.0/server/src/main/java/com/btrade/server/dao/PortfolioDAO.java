package com.btrade.server.dao;

import java.util.List;
import com.btrade.server.model.Portfolio;

public interface PortfolioDAO {
	public List<Portfolio> listPortfolio();
	public List<Portfolio> getPortfolioByAccountNum(String acctNum);
}
