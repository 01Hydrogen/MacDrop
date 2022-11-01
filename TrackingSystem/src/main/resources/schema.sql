INSERT INTO "PUBLIC"."ORDER_INFO" VALUES
('4028828c84309af30184309b49b00000', NULL, '{"menuName":"Orange Chicken","price":6.9,"amount":1,"resId":"Pandas Express"}/{"menuName":"burger","price":12.3,"amount":3,"resId":"res"}/{"menuName":"burger","price":12.3,"amount":2,"resId":"res"}/{"menuName":"ChongQing Noodle","price":13.9,"amount":3,"resId":"sichuan"}/', TIMESTAMP '2022-10-31 20:33:14.082', 'ITB212', NULL, 1, 'Pandas Express,res,res,sichuan,', 0, 'sb@waterloo.ca', 'zy', 51.30199999999999, '30278376-25bf-4b16-97bf-50407ad2dfb6');

INSERT INTO "PUBLIC"."SUB_ORDER_INFO" VALUES
('4028828c84309af30184309b4a000001', 1, NULL, 6.9, 'Pandas Express', 0, '4028828c84309af30184309b49b00000'),
('4028828c84309af30184309b4a020002', 3, NULL, 12.3, 'res', 0, '4028828c84309af30184309b49b00000'),
('4028828c84309af30184309b4a060003', 2, NULL, 12.3, 'res', 0, '4028828c84309af30184309b49b00000'),
('4028828c84309af30184309b4a080004', 3, NULL, 13.9, 'sichuan', 0, '4028828c84309af30184309b49b00000');

