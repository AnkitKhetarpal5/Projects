#include "atm.h"
void main()
{
	short choice;
	Account tabAccounts[200], clientAcc;
	short NbRecords;
	NbRecords = initializeAccounts(tabAccounts);
	do {
		system("clear");
		dispTitle("royal bank");
		dispTitle("automatic banking machine");
		clientAcc = authenticateClient(tabAccounts, NbRecords);
		dispMenu();
		choice = readChoice();
		switch (choice) {
		case 1:
			system("clear");
			clientAcc = depositIntoAccount(clientAcc);
			updateAccount(tabAccounts, clientAcc,NbRecords);
			saveAccountsToFile(tabAccounts, NbRecords);
			initializeAccounts(tabAccounts);
			dispAccountInfo(clientAcc);
			break;
		case 2:
			system("clear");
			clientAcc = withdrawFromAccount(clientAcc);
			updateAccount(tabAccounts, clientAcc, NbRecords);
			saveAccountsToFile(tabAccounts, NbRecords);
			initializeAccounts(tabAccounts);
			dispAccountInfo(clientAcc);
			break;
		case 3:
			system("clear");
			dispAccountInfo(clientAcc);
			break;
		}
	} while (choice != 4);
}
