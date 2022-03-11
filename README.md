# Investment Portfolio API

API for providing an investment portfolio based on the user's risk level, as well
as providing a simulation system for investment suggestions.

## Service integration

This API integrates with [FMP API](https://site.financialmodelingprep.com/developer/) to fetch historical stock prices.
Make sure to create an account and issue an API key to be used.

## Setup

Some environment variables must be set to make it work.

### Setting Environment variables

|    Service   |      Env var key     |  Default value  |
|:-------------|:--------------------:|:---------------:|
|FMP API key   |     `FMP_API_KEY`    |   invalid-key   |
|MongoDB host  |`MONGODB_VITAMIN_HOST`|    localhost    |
|MongoDB port  |`MONGODB_VITAMIN_PORT`|      27017      |
|MongoDB db    | `MONGODB_VITAMIN_DB` |vitamin-challenge|

If you're on Linux, add `export <Env var key>=key-value` to your `~/.bashrc` file.

If you're on Windows, add them to your system environment variables.

## API Endpoints

`POST - /users/me/investment-portfolio`

Retrieves a portfolio based on the provided risk level.

Query params:
- **riskLevel**: Investor risk level, based on the online test. `e.g.: 5`

Response example:

```
[
    {
        "weight": 0.65,
        "ticker": "CAKE"
    },
    {
        "weight": 0.2,
        "ticker": "PZZA"
    },
    {
        "weight": 0.15,
        "ticker": "EAT"
    }
]
```

`POST - /users/me/investment-portfolio/current-value`

Simulates how many shares would be available by monthly investing in a portfolio selected based on the provided risk
level given a time period.

Query params:
- **from**: Starting date for the simulation. `e.g.: 2017-01-01`
- **to**: Ending date for the simulation. `e.g.: 2021-06-03`
- **monthlyContribution**: Monthly contribution investment value. `e.g.: 450.00`
- **riskLevel**: Investor risk level, based on the online test. `e.g.: 5`

Response example:

```
[
    {
        "ticker": "CAKE",
        "value": 22059.93303,
        "shares": 385.461
    },
    {
        "ticker": "PZZA",
        "value": 7459.49792180,
        "shares": 78.20
    },
    {
        "ticker": "EAT",
        "value": 5393.25135,
        "shares": 94.041
    }
]
```