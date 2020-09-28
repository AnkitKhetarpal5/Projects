#pragma once
#include <iostream>
#include <string>
#include <fstream>
using namespace std;
struct Account
{
	string Number;
	string Name;
	string Pin;
	float Balance = 0;
};
void dispTitle(string anyTitle)
{
	short count = 0;
	for (short i = 0; i < anyTitle.length(); i++)
	{
		anyTitle[i] = toupper(anyTitle[i]);
	}
	cout << "\t\t\t" << anyTitle << endl << "\t\t\t";
	for (short i = 0; i < anyTitle.length(); i++)
	{
		if (anyTitle[i] == ' ')
		{
			cout << ' ';
		}
		else
		{
			cout << '-';
		}

	}
	cout << "\n";
}
void dispMenu()
{
	cout << endl;
	cout << "\t1 - Deposit" << endl;
	cout << "\t2 - Withdrawal" << endl;
	cout << "\t3 - Consult" << endl;
	cout << "\t4 - Quit" << endl;
}
short readChoice()
{
	short choice;
	do {
		cout << "\nEnter your choice(1-4): ";
		cin >> choice;
		choice = choice;
	} while (choice != 1 && choice != 2 && choice != 3 && choice != 4);
	return choice;
}
bool validateAccount(Account custAccounts)
{
	bool isAccInitSuccessful = false;
	if (!custAccounts.Number.empty() &&
		!custAccounts.Name.empty() &&
		!custAccounts.Pin.empty())
		isAccInitSuccessful = true;
	return isAccInitSuccessful;
}
short initializeAccounts(Account custAccounts[]) {
	bool isInitSuccessful = true;
	fstream MyFile;
	string line;
	MyFile.open("Bank.txt", ios::in);
	short counter = 0, initCounter = 0, nbRecords = 0;
	Account custAcc;
	while (!MyFile.eof())
	{
		if (initCounter != counter)
		{
			isInitSuccessful = false;
			break;
		}
		counter++;
		getline(MyFile, line);
		switch (initCounter)
		{
		case 0:
			custAcc.Number = line;
			initCounter++;
			break;
		case 1:
			custAcc.Name = line;
			initCounter++;
			break;
		case 2:
			custAcc.Pin = line;
			initCounter++;
			break;
		case 3:
			custAcc.Balance = stof(line);
			initCounter++;
			break;
		}
		if (initCounter % 4 == 0 && validateAccount(custAcc))
		{
			custAccounts[(counter / 4) - 1] = custAcc;
			custAcc.Number = "";
			custAcc.Name = "";
			custAcc.Pin = "";
			custAcc.Balance = 0;
			initCounter = 0;
		}
	}
	MyFile.close();
	return counter / 4;
}
Account authenticateClient(Account custAccounts[], short nbRecords) {
	string Number, Pin, line;
	bool isValidAccNum = false, isValidPass = false;
	Account clientAcc;
	do {
		cin.ignore();
		cout << "\nEnter your Account Number : ";
		getline(cin, Number);
		for (short i = 0; i < nbRecords; i++)
		{
			if (custAccounts[i].Number == Number)
			{
				isValidAccNum = true;
				cout << "\n\t Welcome " << custAccounts[i].Name;
				do {
					cout << "\nEnter your Pin : ";
					getline(cin, Pin);
					if (Pin == custAccounts[i].Pin)
					{
						isValidPass = true;
						clientAcc = custAccounts[i];
						break;
					}
				} while (!isValidPass);
			}
		}
	} while (!isValidAccNum);
	return clientAcc;
}
void dispAccountInfo(Account custAccount)
{
	cout << "\nACCOUNT INFORMATION" << endl;
	cout << "\n\tAccount Number : " << custAccount.Number;
	cout << "\n\tClient : " << custAccount.Name;
	cout << "\n\tPIN : " << custAccount.Pin;
	cout << "\n\tBalance $ : " << custAccount.Balance << endl;
}
void saveAccountsToFile(Account custAccounts[], short nbAccounts)
{
	fstream MyFile;
	string line;
	MyFile.open("Bank.txt", ios::out);
	for (short i = 0; i < nbAccounts; i++)
	{
		MyFile << custAccounts[i].Number << endl;
		MyFile << custAccounts[i].Name << endl;
		MyFile << custAccounts[i].Pin << endl;
		MyFile << custAccounts[i].Balance;
	}
	MyFile.close();
}
void updateAccount(Account custAccounts[], Account custAcc, short nb)
{
	for (short i = 0; i < nb; i++)
	{
		if (custAccounts[i].Number == custAcc.Number)
		{
			custAccounts[i].Balance = custAcc.Balance;
		}
	}
}
Account depositIntoAccount(Account custAcc)
{
	float amount;
	do {
		cout << "enter an amount to deposit($2-$20,000) : ";
		cin >> amount;
	} while ((amount > 20000) || (amount < 2));
	custAcc.Balance += amount;
	return custAcc;
}
Account withdrawFromAccount(Account custAcc)
{
	float amount;
	do {
		cout << "enter an amount to withdraw($20-$500) : ";
		cin >> amount;
	} while (fmod(amount, 20) != 0 || (amount > 500) || (amount < 20) || amount > custAcc.Balance);
	custAcc.Balance -= amount;
	return custAcc;
}