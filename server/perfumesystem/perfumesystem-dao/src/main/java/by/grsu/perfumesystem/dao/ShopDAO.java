package by.grsu.perfumesystem.dao;

import org.springframework.stereotype.Repository;

import by.grsu.perfumesystem.api.dao.IShopDAO;
import by.grsu.perfumesystem.model.Shop;

@Repository
public class ShopDAO extends AbstractDAO<Shop> implements IShopDAO {

}
