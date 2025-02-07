package tech.cassandre.trading.bot.strategy;

import tech.cassandre.trading.bot.dto.market.TickerDTO;
import tech.cassandre.trading.bot.dto.position.PositionDTO;
import tech.cassandre.trading.bot.dto.strategy.StrategyDTO;
import tech.cassandre.trading.bot.dto.trade.OrderDTO;
import tech.cassandre.trading.bot.dto.trade.TradeDTO;
import tech.cassandre.trading.bot.dto.user.AccountDTO;
import tech.cassandre.trading.bot.dto.util.CurrencyPairDTO;
import tech.cassandre.trading.bot.repository.OrderRepository;
import tech.cassandre.trading.bot.repository.PositionRepository;
import tech.cassandre.trading.bot.repository.TradeRepository;
import tech.cassandre.trading.bot.service.ExchangeService;
import tech.cassandre.trading.bot.service.PositionService;
import tech.cassandre.trading.bot.service.TradeService;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Cassandre strategy interface.
 * This allows the framework to communicate with the strategy.
 */
@SuppressWarnings("unused")
public interface CassandreStrategyInterface {

    /**
     * Setter strategyDTO.
     *
     * @param newStrategyDTO strategy DTO.
     */
    void setStrategy(StrategyDTO newStrategyDTO);

    /**
     * Initialize accounts with accounts.
     *
     * @param accounts accounts
     */
    void initializeAccounts(Map<String, AccountDTO> accounts);

    /**
     * Setter order repository.
     *
     * @param newOrderRepository order repository
     */
    void setOrderRepository(OrderRepository newOrderRepository);

    /**
     * Setter trade repository.
     *
     * @param newTradeRepository trade repository.
     */
    void setTradeRepository(TradeRepository newTradeRepository);

    /**
     * Setter positionRepository.
     *
     * @param newPositionRepository the positionRepository to set
     */
    void setPositionRepository(PositionRepository newPositionRepository);

    /**
     * Setter for exchangeService.
     *
     * @param newExchangeService exchange service
     */
    void setExchangeService(ExchangeService newExchangeService);

    /**
     * Setter for tradeService.
     *
     * @param newTradeService the tradeService to set
     */
    void setTradeService(TradeService newTradeService);

    /**
     * Setter for positionService.
     *
     * @param newPositionService position service
     */
    void setPositionService(PositionService newPositionService);

    /**
     * Method called by streams at every account update.
     *
     * @param account account
     */
    void accountUpdate(AccountDTO account);

    /**
     * Method called by streams at every ticker update.
     *
     * @param ticker ticker
     */
    void tickerUpdate(TickerDTO ticker);

    /**
     * Method called by streams on every order update.
     *
     * @param order order
     */
    void orderUpdate(OrderDTO order);

    /**
     * Method called by streams on every trade update.
     *
     * @param trade trade
     */
    void tradeUpdate(TradeDTO trade);

    /**
     * Method called by streams on every position update.
     *
     * @param position trade
     */
    void positionUpdate(PositionDTO position);

    /**
     * Implements this method to tell the bot which currency pairs your strategy will receive.
     *
     * @return the list of currency pairs tickers your want to receive
     */
    Set<CurrencyPairDTO> getRequestedCurrencyPairs();

    /**
     * Implements this method to tell the bot which account from the accounts you own is the trading one.
     *
     * @param accounts all your accounts
     * @return trading account
     */
    Optional<AccountDTO> getTradeAccount(Set<AccountDTO> accounts);

    /**
     * Returns your trading account.
     *
     * @return trading account
     */
    Optional<AccountDTO> getTradeAccount();

    /**
     * Method triggered at every account update.
     *
     * @param account account
     */
    void onAccountUpdate(AccountDTO account);

    /**
     * Method triggered at every ticker update.
     *
     * @param ticker ticker
     */
    void onTickerUpdate(TickerDTO ticker);

    /**
     * Method triggered on every order update.
     *
     * @param order order
     */
    void onOrderUpdate(OrderDTO order);

    /**
     * Method triggered on every trade update.
     *
     * @param trade trade
     */
    void onTradeUpdate(TradeDTO trade);

    /**
     * Method triggered on every position update.
     *
     * @param position position
     */
    void onPositionUpdate(PositionDTO position);

    /**
     * Method triggered on every position status update.
     *
     * @param position position
     */
    void onPositionStatusUpdate(PositionDTO position);

}
