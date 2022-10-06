import mysql.connector
from rich import print as printc
from rich.console import Console
console = Console()
  
def dbconfig():
  try:
    db = mysql.connector.connect(
      host ="localhost",
      user ="pm",
      passwd ="password"
    )
    # printc("[green][+][/green] Connected to db")
  except Exception as e:
    print("[red][!] An error occurred while trying to connect to the database[/red]")
    console.print_exception(show_locals=True)

  return db