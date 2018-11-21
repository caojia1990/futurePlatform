DROP TABLE IF EXISTS INVESTOR_INSTRUMENT;
create table INVESTOR_INSTRUMENT(
    INVESTOR_NO VARCHAR(10) not null,
    INSTRUMENT_ID VARCHAR(10),
    VOLUME int,
    STOP_WIN INT,
    STOP_LOSS INT,
    STATUS CHAR,
    TARGET DOUBLE,
    RETRACEMENT DOUBLE,
    HEDGING_TYPE CHAR,
    HEDGING_TIGGER DOUBLE,
    HEDGING_VOLUME INT,
    HEDGING_STOP_WIN DOUBLE,
    HEDGING_STOP_LOSS DOUBLE
);

DROP TABLE IF EXISTS STAIRCASE_HEDGING;
create table STAIRCASE_HEDGING(
    INSTRUMENT_ID VARCHAR(10),
    HEDGING_BEGIN_TICK INT,
    HEDGING_END_TICK INT,
    HEDGING_VOLUME INT
);
