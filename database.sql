CREATE TABLE user_point (
  id int(11) NOT NULL AUTO_INCREMENT,
  user_id int(11) unsigned NOT NULL,
  level tinyint(4) NOT NULL DEFAULT 0,
  points int(8) unsigned DEFAULT 0,
  PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8;

CREATE TABLE user_point_history(
  id int(11) NOT NULL AUTO_INCREMENT,
  user_id int(11) unsigned NOT NULL,
  balance int(8) unsigned DEFAULT 0,
  operate tinyint(4) NOT NULL COMMENT '1: ADD 2: SUBSTRACT',
  `date` date NOT NULL,
  PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8;

CREATE TABLE user_redeem_history (
  id int(11) NOT NULL AUTO_INCREMENT,
  user_id int(11) unsigned NOT NULL,
  coupon_id int(11) unsigned NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8;

CREATE TABLE coupon_pool (
  id int(11) NOT NULL AUTO_INCREMENT,
  coupon_id int(11) unsigned NOT NULL,
  status tinyint(4) unsigned DEFAULT 1 COMMENT '1: available 0: redeemed',
  `date` date NOT NULL,
  PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8;
