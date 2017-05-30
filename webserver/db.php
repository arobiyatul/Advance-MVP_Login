<?php 
	include 'config.php';

	/**
	* 
	*/
	class DbConnect{
		private $connect
		public function __construct()
		{
			$this->connect = mysqli_connect(DB_HOST, DB_USER, DB_PASSWORD, DB_NAME);

			if (mysql_connect_errno($this->connect)) {
				echo "Failed to connect to mysql" . mysql_connect_error();
			}
		}

		public function getDb()
		{
			return $this->connect;
		}
	}
 ?>