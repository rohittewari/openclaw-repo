# TRD (V2)

## Suggested AWS Stack
- S3, Kinesis, Firehose, Glue, Glue Catalog, Athena, QuickSight
- Optional OpenSearch
- CloudWatch, CloudTrail, IAM, KMS, Lake Formation

## NFRs
- Availability target 99.9%
- Data freshness <= 15 min (95th percentile)
- Dashboard SLA <= 30 min

## Security
- Least privilege IAM
- Encryption in transit + at rest
- Audit logging enabled
