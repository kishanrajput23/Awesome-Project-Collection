from utils.dbconfig import dbconfig
import utils.aesutil
import pyperclip

from Crypto.Protocol.KDF import PBKDF2
from Crypto.Hash import SHA512
from Crypto.Random import get_random_bytes
import base64

from rich import print as printc
from rich.console import Console
from rich.table import Table

def computeMasterKey(mp,ds):
	password = mp.encode()
	salt = ds.encode()
	key = PBKDF2(password, salt, 32, count=1000000, hmac_hash_module=SHA512)
	return key

def retrieveEntries(mp, ds, search, decryptPassword = False):
	db = dbconfig()
	cursor = db.cursor()

	query = ""
	if len(search)==0:
		query = "SELECT * FROM pm.entries"
	else:
		query = "SELECT * FROM pm.entries WHERE "
		for i in search:
			query+=f"{i} = '{search[i]}' AND "
		query = query[:-5]

	cursor.execute(query)
	results = cursor.fetchall()

	if len(results) == 0:
		printc("[yellow][-][/yellow] No results for the search")
		return

	if (decryptPassword and len(results)>1) or (not decryptPassword):
		if decryptPassword:
			printc("[yellow][-][/yellow] More than one result found for the search, therefore not extracting the password. Be more specific.")
		table = Table(title="Results")
		table.add_column("Site Name")
		table.add_column("URL",)
		table.add_column("Email")
		table.add_column("Username")
		table.add_column("Password")

		for i in results:
			table.add_row(i[0], i[1], i[2], i[3], "{hidden}")
		console = Console()
		console.print(table)
		return 

	if decryptPassword and len(results)==1:
		# Compute master key
		mk = computeMasterKey(mp,ds)

		# decrypt password
		decrypted = utils.aesutil.decrypt(key=mk,source=results[0][4],keyType="bytes")

		printc("[green][+][/green] Password copied to clipboard")
		pyperclip.copy(decrypted.decode())

	db.close()
